type FirstChar<T extends string> = T extends `${infer L}${infer R}` ? L : never
type A = FirstChar<'abc'>