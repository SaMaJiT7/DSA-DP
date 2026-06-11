package segment_tree;

public class RMQ {
    static int st[];

    public static int[] constructST(int arr[], int n) {
        st = new int[4*n];
        buildSGT(0,0,n-1,st,arr);
        return st;
    }
    public static int RMQ(int st[], int n, int l, int r) {
        return Query(l,r,0,0,n-1,st);
    }
    public static void buildSGT(int i, int l, int r, int[] st, int[] arr){
        if(l == r){
            st[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        buildSGT(2*i+1,l,mid,st,arr);
        buildSGT(2*i+2,mid+1,r,st,arr);

        st[i] = Math.min(st[2*i+1],st[2*i+2]);
    }


    static int Query(int start, int end,int i, int l,int r,int[] st){
        if(l > r){
            return Integer.MAX_VALUE;
        }
        if(l > end || r < start){
            return Integer.MAX_VALUE;
        }

        if(l >= start && r <= end){
            return st[i];
        }

        int mid = l + (r-l)/2;
        return Math.min(Query(start,end,2*i+1,l,mid,st),Query(start,end,2*i+2,mid+1,r,st));
    }
}
