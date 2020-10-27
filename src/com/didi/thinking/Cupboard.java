package com.didi.thinking;

import static com.didi.thinking.Util.print;

public class Cupboard {
    Bowl bowl3 = new Bowl(3);//非静态
    static Bowl bowl4 = new Bowl(4);//静态
    Cupboard() {
        print("Cupboard()");
        bowl4.f1(2);
    }
    void f3(int marker) {
        print("f3(" + marker + ")");
    }
    static Bowl bowl5 = new Bowl(5);
}
