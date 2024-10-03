from collections import defaultdict

class GroupAnagrams:
    def anagrams(self, strs):
        if len(strs) == 0:
            return []
        
        # create a map where the key is the sorted string and the value is the list of strings
        anagram_map = defaultdict(list)
        
        for s in strs:
            # sort the string to use as a key
            key = ''.join(sorted(s))
            
            # add the original string to the list of its corresponding sorted key
            anagram_map[key].append(s)
        
        # return the grouped anagrams as a list of lists
        return list(anagram_map.values())

# Example usage
if __name__ == "__main__":
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    group_anagrams = GroupAnagrams()
    result = group_anagrams.anagrams(strs)
    print(result)
