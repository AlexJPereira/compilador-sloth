import java.util.List;
import java.util.ListIterator;

public class ExpressionOp implements CompiladorSlothConstants{

    private int ERRORTYPE = -1;

    public int expressionReturn(List<Integer> exp){
        ListIterator<Integer> litr = exp.listIterator();
        int elem, set=ERRORTYPE, previous=ERRORTYPE, next=ERRORTYPE;

        if(exp.size()==0)
            return TIPOVOID-TIPOINT;

        while(litr.hasNext()){
            elem = litr.next();
            if(elem==NOT){
                litr.remove();
                if(litr.next()!=TIPOBOOLEAN-TIPOINT) return ERRORTYPE;
            }
            if(elem==TIPOVOID-TIPOINT){
                return TIPOVOID-TIPOINT;
            }
        }

        for(int i=0;i<5;i++){
            litr = exp.listIterator();
            int[] operador = opType(i);
            while(litr.hasNext()){
                elem = litr.next();
                if(elem>=operador[0]&&elem<=operador[1]){
                    next = litr.next();
                    litr.remove();
                    litr.previous();
                    set = callOp(i, previous, next);
                    if(set==ERRORTYPE) return ERRORTYPE;
                    litr.set(set);
                    litr.previous();
                    litr.remove();
                }
                previous = elem;
            }
        }
        return exp.get(0);
    }

    public boolean canReceive(int num, int rec){
        return canExpReceive[num][rec];
    }

    private int[] opType(int i){
        switch(i){
            case 0:
                int pow[] = {POW,POW}; 
                return pow;
            case 1:
                int arit[] = {SUB,DIV}; 
                return arit;
            case 2:
                int add[] = {ADD,ADD}; 
                return add;
            case 3:
                int rel[] = {IGUAL,MEIGUAL}; 
                return rel;
            case 4:
                int log[] = {AND,NOT}; 
                return log;
        }
        return new int[2];
    }

    private int callOp(int i, int previous, int next){
        switch(i){
            case 0:
                return opPow(previous,next);
            case 1:
                return opArit(previous,next);
            case 2:
                return opAdd(previous,next);
            case 3:
                return opRel(previous,next);
            case 4:
                return opLog(previous,next);
        }
        return -1;
    }

    private int opAdd(int typeA, int typeB){
        return opAddRet[typeA][typeB];
    }

    private int opArit(int typeA, int typeB){
        return opAritRet[typeA][typeB];
    }

    private int opPow(int typeA, int typeB){
        return opPowRet[typeA][typeB];
    }

    private int opRel(int typeA, int typeB){
        return opRelRet[typeA][typeB];
    }

    private int opLog(int typeA, int typeB){
        return opLogRet[typeA][typeB];
    }

    private boolean canExpReceive[][] = {
        //int   dou     char    str     bool
        {true,  true,   false,   false,  false   },         //int       = 0
        {false, true,   false,  false,  false   },         //double    = 1
        {true,  true,   true,   false,  false   },         //char      = 2
        {false, false,  false,  true,   false   },         //string    = 3
        {false, false,  false,  false,  true    }          //boolean   = 4
    };

    private int opAddRet[][] = {
        //int   dou     char    str     bool
        {0,     1,      0,      3,      -1      },         //int       = 0
        {1,     1,      1,      3,      -1      },         //double    = 1
        {0,     1,      2,      3,      -1      },         //char      = 2
        {3,     3,      3,      3,      3       },         //string    = 3
        {-1,    -1,     -1,     3,      -1      }         //boolean   = 4
    };

    private int opAritRet[][] = {
        //int   dou     char    str     bool
        {0,     1,      0,      -1,     -1      },         //int       = 0
        {1,     1,      1,      -1,     -1      },         //double    = 1
        {0,     1,      2,      -1,     -1      },         //char      = 2
        {-1,    -1,     -1,     -1,     -1      },         //string    = 3
        {-1,    -1,     -1,     -1,     -1      }         //boolean   = 4
    };

    private int opPowRet[][] = {
        //int   dou     char    str     bool
        {1,     1,      1,      -1,     -1      },         //int       = 0
        {1,     1,      1,      -1,     -1      },         //double    = 1
        {1,     1,      1,      -1,     -1      },         //char      = 2
        {-1,    -1,     -1,     -1,     -1      },         //string    = 3
        {-1,    -1,     -1,     -1,     -1      }         //boolean   = 4
    };

    private int opRelRet[][] = {
        //int   dou     char    str     bool
        {4,     4,      4,      -1,     -1      },         //int       = 0
        {4,     4,      4,      -1,     -1      },         //double    = 1
        {4,     4,      4,      -1,     -1      },         //char      = 2
        {-1,    -1,     -1,     -1,     -1      },         //string    = 3
        {-1,    -1,     -1,     -1,     4       }         //boolean   = 4
    };

    private int opLogRet[][] = {
        //int   dou     char    str     bool
        {-1,    -1,     -1,     -1,     -1      },         //int       = 0
        {-1,    -1,     -1,     -1,     -1      },         //double    = 1
        {-1,    -1,     -1,     -1,     -1      },         //char      = 2
        {-1,    -1,     -1,     -1,     -1      },         //string    = 3
        {-1,    -1,     -1,     -1,     4       }         //boolean   = 4
    };
}