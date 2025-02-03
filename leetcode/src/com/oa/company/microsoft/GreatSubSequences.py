MOD = 10**9 + 7

def solution(A, queries):
    N = len(A)
    if N == 0:
        return 0
    
    max_val = max(A) if A else 0
    for query in queries:
        X, Y = query
        max_val = max(max_val, Y)
    
    max_d = max_val
    if max_d < 1:
        max_d = 1
    
    # Precompute Möbius function
    mu = [1] * (max_d + 1)
    is_prime = [True] * (max_d + 1)
    for p in range(2, max_d + 1):
        if is_prime[p]:
            for multiple in range(p, max_d + 1, p):
                is_prime[multiple] = False if multiple != p else is_prime[multiple]
                mu[multiple] *= -1
            p_square = p * p
            for multiple in range(p_square, max_d + 1, p_square):
                mu[multiple] = 0
    
    # Precompute divisors for each number up to max_d
    divisors = [[] for _ in range(max_d + 1)]
    for d in range(1, max_d + 1):
        for multiple in range(d, max_d + 1, d):
            divisors[multiple].append(d)
    
    # Precompute powers of 2
    pow2 = [1] * (N + 2)
    for i in range(1, N + 2):
        pow2[i] = (pow2[i-1] * 2) % MOD
    
    # Initialize count for each divisor
    cnt = [0] * (max_d + 1)
    for num in A:
        for d in divisors[num]:
            if d <= max_d:
                cnt[d] += 1
    
    # Compute initial S
    S = 0
    for d in range(1, max_d + 1):
        if mu[d] != 0 and cnt[d] > 0:
            term = mu[d] * (pow2[cnt[d]] - 1) % MOD
            S = (S + term) % MOD
    
    T = (pow2[N] - 1) % MOD
    sum_ans = 0
    
    for query in queries:
        X, Y = query
        idx = X - 1
        old_val = A[idx]
        new_val = Y
        
        # Process old_val: subtract its divisors' contributions
        for d in divisors[old_val]:
            if d > max_d:
                continue
            if mu[d] == 0:
                continue
            term_old = mu[d] * (pow2[cnt[d]] - 1) % MOD
            S = (S - term_old) % MOD
            cnt[d] -= 1
            term_new = mu[d] * (pow2[cnt[d]] - 1) % MOD if cnt[d] >= 0 else 0
            S = (S + term_new) % MOD
        
        # Process new_val: add its divisors' contributions
        for d in divisors[new_val]:
            if d > max_d:
                continue
            if mu[d] == 0:
                continue
            term_old = mu[d] * (pow2[cnt[d]] - 1) % MOD
            S = (S - term_old) % MOD
            cnt[d] += 1
            term_new = mu[d] * (pow2[cnt[d]] - 1) % MOD
            S = (S + term_new) % MOD
        
        A[idx] = new_val
        great = (T - S) % MOD
        sum_ans = (sum_ans + great) % MOD
    
    return sum_ans