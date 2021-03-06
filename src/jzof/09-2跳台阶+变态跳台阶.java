//第1题:跳台阶
//判题OJ:https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int fisrt = 1;
        int second = 2;
        int third = 3;
        for (int i = 2; i < n; i++) {
            third = fisrt + second;
            fisrt = second;
            second = third;
        }
        return third;
    }
    ********************************
     //第2题:变态跳台阶
    //判题OJ:https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
    每个台阶可以看作一块木板,让青蛙跳上去,n个台阶就有n块木板,最后一块木板是青蛙到达的位子,必须存在,
   其他n-1块木板可以任意选择是否存在,则每个木板有存在和不存在两种选择,n-1块木板就有
   2^(n-1)种,可以直接得到结果,不用那么麻烦分析吧
    public int JumpFloorII(int target) {
         return 1<< target-1;
    }
