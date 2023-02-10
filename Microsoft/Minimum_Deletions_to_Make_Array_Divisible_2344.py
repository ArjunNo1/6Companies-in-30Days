from math import gcd
class Solution:
    def minOperations(self, nums: List[int], numsDivide: List[int]) -> int:
        
        g = gcd(*numsDivide)
        nums.sort()
        d=0
        for i in nums:
            if (g%i != 0):
                d+=1
            else:
                return d
        return -1