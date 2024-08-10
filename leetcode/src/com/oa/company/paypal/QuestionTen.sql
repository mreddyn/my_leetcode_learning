SELECT
    c.tier AS tier,
    CONCAT(
        FLOOR(SUM(TIMESTAMPDIFF(SECOND, d.dt_start, d.dt_end)) / (24 * 3600)), ' days ',
        MOD(FLOOR(SUM(TIMESTAMPDIFF(SECOND, d.dt_start, d.dt_end)) / 3600), 24), ' hours ',
        MOD(FLOOR(SUM(TIMESTAMPDIFF(SECOND, d.dt_start, d.dt_end)) / 60), 60), ' minutes ',
        MOD(SUM(TIMESTAMPDIFF(SECOND, d.dt_start, d.dt_end)), 60), ' seconds'
    ) AS total
FROM
    configurations c
JOIN
    deployments d ON c.id = d.configuration_id
WHERE
    YEAR(d.dt_start) = 2021 AND YEAR(d.dt_end) = 2021
GROUP BY
    c.tier
ORDER BY
    c.tier ASC;