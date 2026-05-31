class Solution {
public:
    bool isPalindrome(string s) {
        removeSpecialCharacter(s);

        int p1 = s.length() - 1 ;
        int p2 = 0;
        cout << s << endl;
        for (int i = 0; i < s.length() /2 ; i++) {
            if (s[p1] != s[p2]) 
                return false;
            else {
                p1 --;
                p2 ++;
            }
        }

        return true;
    }

    void removeSpecialCharacter(string& s) {
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        for (int i = 0; i < s.length(); i++){
            if ((s[i] < 'a' || s[i] > 'z') && (s[i] < '0' || s[i] > '9')) {
                        
                        s.erase(i, 1);
                        i--;
                        cout<< s << endl;
                    }
        }

    }
};
