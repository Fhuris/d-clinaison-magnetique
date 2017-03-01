package legendre;

public class Normalisation {
	
		  private Normalisation(){}
		  
		  public static double legendre(final int l, final int m, final double x) {
		    int i,ll;
		    double fact,oldfact,pll=0,pmm,pmmp1,omx2;
		    if (m < 0 || m > l || Math.abs(x) > 1.0)
		      throw new IllegalArgumentException("mauvais argument legendre");
		    pmm=1.0;
		    if (m > 0) {
		      omx2=(1.0-x)*(1.0+x);
		      fact=1.0;
		      for (i=1;i<=m;i++) {
		        pmm *= omx2*fact/(fact+1.0);
		        fact += 2.0;
		      }
		    }
		    pmm=Math.sqrt((2*m+1)*pmm/(4.0*Math.PI));
		    if ((m & 1)!=0)
		      pmm=-pmm;
		    if (l == m)
		      return pmm;
		    else {
		      pmmp1=x*Math.sqrt(2.0*m+3.0)*pmm;
		      if (l == (m+1))
		        return pmmp1;
		      else {
		        oldfact=Math.sqrt(2.0*m+3.0);
		        for (ll=m+2;ll<=l;ll++) {
		          fact=Math.sqrt((4.0*ll*ll-1.0)/(ll*ll-m*m));
		          pll=(x*pmmp1-pmm/oldfact)*fact;
		          oldfact=fact;
		          pmm=pmmp1;
		          pmmp1=pll;
		        }
		        return pll;
		      }
		    }
		  }
		  
		  public static double plgndr(final int l, final int m, final double x){
		    if (m < 0 || m > l || Math.abs(x) > 1.0)
		      throw new IllegalArgumentException("mauvais argument legendre");
		    double prod=1.0;
		    for (int j=l-m+1;j<=l+m;j++)
		      prod *= j;
		    return Math.sqrt(4.0*Math.PI*prod/(2*l+1))*legendre(l,m,x);
		  }
		}


