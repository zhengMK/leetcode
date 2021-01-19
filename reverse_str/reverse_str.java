// swap the front and back until they meet each other
class Solution {
    public void reverseString(char[] s) {
        for (int front = 0, back = s.length - 1; front < back; front++, back--) {
            char temp = s[front];
            s[front] = s[back];
            s[back] = temp;
        }
    }
}