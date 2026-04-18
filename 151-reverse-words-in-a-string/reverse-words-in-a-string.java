class Solution{
public String reverseWords(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;

    // Step 1: Reverse the entire array
    reverse(chars, 0, n - 1);
    // Step 2: Reverse each word and compact
    int write = 0;
    for (int i = 0; i < n; i++) {
        if (chars[i] != ' ') {
            if (write > 0) chars[write++] = ' ';
            int wordStart = write;
            while (i < n && chars[i] != ' ') {
                chars[write++] = chars[i++];
            }
            reverse(chars, wordStart, write - 1);
        }
    }

    return new String(chars, 0, write);
}

private void reverse(char[] c, int l, int r) {
    while (l < r) {
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        l++;
        r--;
    }
}
}