def getMinFlips(pwd: str) -> int:
    N = len(pwd)
    # Initialize DP array with infinity
    dp = [float('inf')] * (N + 1)
    dp[0] = 0  # No flips needed for empty string

    # Precompute cumulative counts of '0's and '1's
    cum0 = [0] * (N + 1)
    cum1 = [0] * (N + 1)
    for i in range(1, N + 1):
        cum0[i] = cum0[i - 1] + (1 if pwd[i - 1] == '0' else 0)
        cum1[i] = cum1[i - 1] + (1 if pwd[i - 1] == '1' else 0)

    for i in range(2, N + 1, 2):
        # Iterate over all possible even lengths k ending at i
        for k in range(2, i + 1, 2):
            j = i - k  # Start index of the substring
            print(j, ' ', i)
            # Number of '1's in the substring [j, i) to make all '0's
            flips_to_0 = cum1[i] - cum1[j]
            # Number of '0's in the substring [j, i) to make all '1's
            flips_to_1 = cum0[i] - cum0[j]
            # Minimum flips for this substring
            min_flips = min(flips_to_0, flips_to_1)
            # Update DP
            if dp[j] + min_flips < dp[i]:
                dp[i] = dp[j] + min_flips

    return dp[N]

# Example usage:
if __name__ == "__main__":
    # Test cases
    test_cases = [
        ("1110011000", 3),
        ("100110", 3),
        ("0000", 0),
        ("0101", 2),
        ("1100", 0),
        ("101010", 3)
    ]

    for pwd, expected in test_cases:
        result = getMinFlips(pwd)
        print(f"Password: {pwd} | Minimum Flips: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")
