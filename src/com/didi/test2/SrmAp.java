package com.didi.test2;

import com.didi.test.ApInfo;

public class SrmAp {


    protected class MySrmAp implements ApInfo{
        private String apInv = "FP123" ;

        @Override
        public String getApInvNum() {
            return apInv;
        }
    }
}
