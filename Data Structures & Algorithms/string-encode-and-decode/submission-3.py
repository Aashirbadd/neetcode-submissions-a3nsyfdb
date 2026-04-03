class Solution:

    def encode(self, strs: List[str]) -> str:
        outputStr = ""
        for s in strs:
            outputStr += "*"
            outputStr += str(len(s))
            outputStr += "*"
            outputStr += s
        
        outputStr += "0" # Stop.
        
        print(outputStr)

        return outputStr

    def decode(self, s: str) -> List[str]:
        strs = []

        i = 0
        while s[i] == "*":
            i += 1
            startNum = i

            while s[i] != "*":
                i += 1
            
            endNum = i-1

            print(startNum)
            print(endNum)

            strLen = 0
            if(startNum == endNum):
                strLen = int(s[startNum])
            else:
                strLen = int( s[startNum:endNum+1])
            
            print("StrLen: ")
            print(strLen)
            
            i += 1
            strs.append(s[i : i+strLen])

            i += strLen

        return strs




# You need to encode a list of strings into a single string
# Input: ["neet","code","love","you"]

# Encoding: "*40*neet*4*code*4*love*3*you0"
#                    ^                 
# Output: ["neet", "code", "love", "you"]
# Output:["neet","code","love","you"]

# Constraints?
 # What characters are permitted? UTF8
 # Strs.len < 100, strs[i].len < 200


# Decode the single string back into a list of strings