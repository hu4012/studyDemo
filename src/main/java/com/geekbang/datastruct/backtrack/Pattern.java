package com.geekbang.datastruct.backtrack;

/**
 * describe:
 *
 * @author hu
 * @date 2020/12/21
 * @time 21:00
 */

public class Pattern {
    private boolean matched = false;
    private char[] pattern;
    private int plen;

    public Pattern(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean isMatched(char[] text, int tlen) {
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {
        if (matched) {
            return;
        }
        if (pj == plen) {
            if (ti == tlen) {
                matched = true;
                return;
            }
        }
        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen - ti; k++) {
                rmatch(ti + k, pj + 1, text, tlen);
            }
        } else if (pattern[pj] == '?') {
            rmatch(ti, pj + 1, text, tlen);
            rmatch(ti + 1, pj + 1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            rmatch(ti + 1, pj + 1, text, tlen);
        }
    }
}
