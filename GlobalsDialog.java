/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author mtg
 */
public class GlobalsDialog {
   
   static boolean showDialogHelp=false;
   
   static boolean showDialogAbout=false;
   
   static boolean showingDialog=false;
   
   static void updateShowingDialog()
   {
      showingDialog = showDialogHelp==true || showDialogAbout==true;
   }
   
}
