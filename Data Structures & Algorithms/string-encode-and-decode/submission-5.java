class Solution {
    char delimiter = '#';

    // Encode: [5#123454#jack4#ruby5#54321#]
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String s : strs) {
            int length = s.length();
            builder.append(length).append(delimiter).append(s);
            // "4#1234"
        }

        // append a end key (like a termination), another #
        builder.append(delimiter);

        return builder.toString();
    }

    public List<String> decode(String str) {
        // Encode: [5#123454#jack4#ruby5#54321#]
        //                 ^ 
        int index = 0;
        char[] strList = str.toCharArray();
        List<String> output = new ArrayList<String>();

        while (strList[index] != delimiter) {
            int lenStartIndex = index;
            int lenEndIndex = index + 1;
            while (strList[lenEndIndex] != '#') {
                lenEndIndex++;
            }
            int length = Integer.parseInt(new String(strList, lenStartIndex, lenEndIndex - lenStartIndex));

            int decodedStringStartIndex = lenEndIndex + 1;
            String decodedString = new String(strList, decodedStringStartIndex, length);

            output.add(decodedString);
            
            index = decodedStringStartIndex + length;
        }

        return output;
    }
}

// You're given a list of stings. Encode it to a single string, 
// and be able to decode that to a single string.

// Constraints: ListSize <100, StringLength <200;

// Delimiter should be a number, then a closing thing.
// ie input = 12345
// 5#12345
// Then we will know when the string starts, and when the number ends.
// input: [12345, jack, ruby, 54321]
// Encode: [5#123454#jack4#ruby5#54321]
//                                   ^
// Decode:
// [12345, jack, ruby, 54321]
// Seems bulletproof. Let's get cracking. 