package com.example.tutu.benchmark;

public class CPUFixedPoint implements IBenchmark {

    private int result;
    private int size;

    int num[] ={0,1,2,3};
    int j,k,l;

    int a[],b[],c[];

    int int_arithmetic(int size)
    {
        int res[]= new int[size*2];
        for(int i=0;i<size;i++)
        {
            j=num[1]*(k-j)*(l-k);
            k=num[3]*k -(l-j)*k;
            l=(l-k)*(num[2]+j);
            res[i]=j+k+l;
            res[i*2]=j*k*l;
        }
        return res[2];
    }
    public static final int INT_ARITHMETIC_OPS=28;

    int branching(int size)
    {
        for(int i=0;i<size;i++)
        {
            if(j==1){j=num[2];}
            else{j=num[3];}
            if(j>j){j=num[0];}
            else{j=num[1];}
            if(j<1){j=num[1];}
            else{j=num[0];}
        }
        return j;
    }
    public static final int BRANCHING_OPS=17;

    int arr_access_assignments(int size)
    {
        for(int i=0;i<size;i++)
            c[i]=a[b[i]];

        return c[0];
    }
    public static final int ARR_ACCESS_ASSIGNMENTS_OPS=6;

    public void initialize(Object... params) {
        size=(Integer) params[0];
        j=1;
        k=1;
        l=1;

        a=new int[size];
        b=new int[size];
        c=new int[size];
        for(int i=0;i<size;i++)
        {
            a[i]=i;
            b[i]=size-1-i;
        }
    }

    @Override
    public void warmup() {

        int_arithmetic(size);

        //branching(size);

        //arr_access_assignments(size);
    }

    @Override
    public void run() {
        int_arithmetic(size);
    }

    @Override
    public void run(Object... params) {
        switch ((NumberRepresentation) params[0])
        {
            case INT_ARITHMETIC:
            System.out.println(int_arithmetic(size));
            break;
            case BRANCHING:
            System.out.println(branching(size));
            break;
            case ARR_ACCESS_ASSIGNMENTS:
            System.out.println(arr_access_assignments(size));
            break;
            default: break;
        }
    }

    @Override
    public void cancel() {}

    @Override
    public void clean() {}
}
