class RateMazeProblem {
   static int[][] dir={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static String[] dirS={"D", "L", "U", "R"};
    static ArrayList<String> base=new ArrayList<>();
    public static ArrayList<String> printPath(int[][] m, int n) 
    {
        floodfill(m,n,0,0,n-1,n-1,"");
        return base;
    }
    public static void floodfill(int[][] m,int n,int sr, int sc, int er, int ec, String ans){
    if (sr == er && sc == ec)
    {   
        base.add(ans);
        return ;
    }

    m[sr][sc]=0;
    for (int d = 0; d < dir.length; d++)
    {

        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < m.length && c < m[0].length && m[r][c] == 1)
        {
            floodfill(m,n,r, c, er, ec, ans + dirS[d]);
        }
    }
    m[sr][sc]=1;
}
}