package Accessibility;

public class Family {

   Home home = new Home ();

   void accessMethods () {
	  home.pubicAccess ();
	  home.defaultAccess ();
	  home.protectedAccess ();
   }
}
