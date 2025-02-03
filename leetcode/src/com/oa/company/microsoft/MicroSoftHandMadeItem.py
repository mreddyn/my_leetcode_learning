from collections import deque
from typing import List

class Solution:
  def microsoftHandmadeItem(self, T: List[int]) -> int:
    queue = deque(T)
    res = 0
    count = 0
    while queue:
        # print(queue)
        first = queue.popleft()
        count += 1
        first -= 1
        if first > 0:
          queue.append(first)
        elif first == 0:
          res += count
    return res

# Create an instance of the Solution class
solution = Solution()
# Call the method on the instance
print(solution.microsoftHandmadeItem([7,7,7])) # 55