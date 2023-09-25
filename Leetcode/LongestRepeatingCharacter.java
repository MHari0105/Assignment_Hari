
class LongestRepeatingCharacter {
  public int characterReplacement(String s, int k) {

    int[] dic = new int[26];
    int start = 0;
    int maxLen = 0;

    for (int end = 0; end < s.length(); end++) {
      maxLen = Math.max(maxLen, ++dic[s.charAt(end) - 'A']);
      if (end - start + 1 > maxLen + k) {
        dic[s.charAt(start) - 'A']--;
        start++;
      }
    }
    return s.length() - start;
  }
}