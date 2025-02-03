
from typing import List


class Solution:
  def calculateLeftoverStacks(self, stacks: List[int]) -> int:
      i = 0
      while i < len(stacks):
          current = stacks[i]
          remainder = current % 2
          quotient = current // 2
          stacks[i] = remainder
          if quotient > 0:
              if i+1 < len(stacks):
                stacks[i+1] += quotient
              else:
                stacks.append(quotient)
          i += 1
        
      return sum(1 for x in stacks if x == 1)
    
s = Solution()
print(s.calculateLeftoverStacks([5, 3, 1])) # 4  
            