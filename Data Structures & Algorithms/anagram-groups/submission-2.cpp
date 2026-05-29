class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        vector<string> set;

        for(int i = 0; i < strs.size(); i++){
            set.push_back(strs[i]);
            for(int j = i+1; j< strs.size(); j++){
                if(isAnagram(strs[i],strs[j])){
                    set.push_back(strs[j]);
                    strs.erase(strs.begin() + j);
                    j--;
                }
            }
            result.push_back(set);
            set.clear();
        }
        

        return result;

    }

    bool isAnagram(string s1, string s2){
        if(s1.size() != s2.size()) return false;

        unordered_map<char,int> s1_count;
        unordered_map<char,int> s2_count;

        for(int i = 0; i < s1.size(); i++){
            s1_count[s1[i]]++;
            s2_count[s2[i]]++;
        }

        for(int i = 0 ; i < s1_count.size(); i++)
            if(s1_count[i] != s2_count[i]) return false;
        
        return true;
    }
};
