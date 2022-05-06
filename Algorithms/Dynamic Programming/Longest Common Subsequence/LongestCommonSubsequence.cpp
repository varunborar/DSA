#include <iostream>
#include <vector>

using namespace std;

int longestCommonSubsequence(string text1, string text2)
{
    int n = text1.length() + 1;
    int m = text2.length() + 1;

    vector<vector<int>> lcs(n, vector<int>(m, 0));

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < m; ++j)
        {
            if (i == 0 || j == 0)
            {
                continue;
            }

            if (text1[i - 1] == text2[j - 1])
            {
                lcs[i][j] = 1 + lcs[i - 1][j - 1];
            }
            else
            {
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
    }
    return lcs[n - 1][m - 1];
}

int main()
{
    return 0;
}