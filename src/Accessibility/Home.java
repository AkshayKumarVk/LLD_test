package Accessibility;

public class Home {
   private void privateAccess () {
	  System.out.println ("Private");
   }

   public void pubicAccess () {
	  System.out.println ("Public");
   }

   protected void protectedAccess () {
	  System.out.println ("Protected");
   }
   void  defaultAccess(){
	  System.out.println ("Default");
   }

   private void privateAttribute () {
   }

   class  subFamily{
	  void AccessMethds(){
		 protectedAccess ();
	  }
   }

}
