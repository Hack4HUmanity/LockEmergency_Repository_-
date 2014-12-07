package com.example.lockemergency;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import android.R.layout;
import android.media.MediaPlayer;
import android.media.MediaRecorder;

import android.app.Activity;

import android.os.Bundle;
import android.os.Environment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	   //voice recording
	   private MediaRecorder myAudioRecorder;
	   private String outputFile = null;

	 
		//buttons
	    Button btn1;
		Button btn2;
		Button btn3;
		Button btn4;
		Button btn5;
		Button btn6;
		Button btn7;
		Button btn8;
		Button btn9;
		Button btn10;
		
		
		
		//contact string
		 String s="";
		
        //the saved password
		String password;
		
		String password2;
		
		//to store the password input
		private LinkedList<String> ll = new LinkedList<String>();
		
		//to store the contact number 
		private LinkedList<String> ll2 = new LinkedList<String>();

		Boolean enterContact;
    	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	 enterContact=false;
    	
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        
        button1Clicked();
        button2Clicked();
        button3Clicked();
        button4Clicked();
        button5Clicked();
        button6Clicked();
        button7Clicked();
        button8Clicked();
        button9Clicked();
        button10Clicked();
        
        //this is the password the input should equal to
		password = "[1, 2, 3, 4]";
		
		password2="[1, 9, 9, 6]";
		
		//audio recording setup
		      
	    myAudioRecorder = new MediaRecorder();
	    myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
	    myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
	    myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
	    
        //save the rocorded file in this directory
	    myAudioRecorder.setOutputFile("/sdcard/Ringtones/test.3gp");

	 
    }
    
    //checks if input is equal to password 
    public Boolean checkPassword(){

		if(ll.toString().equals(password)){
			return true;
		}
	
	return false;
			
}
    public void checkPassword2(){

		if(ll.toString().equals(password2)){
			Log.d("pass2 ","in");
			 onDestroy();
			 
		}
	
}
    
   public void checkAlert(){
	   
		//TextView textarea2 = (TextView)findViewById(R.id.text2);
		
    	if(checkPassword()) {
    		
    		 sendSMS("9178596867","Help me , i'm at "+ "http://maps.google.com/?q=<lat>,<lng>");
    	  //send sms
    	 sendSMS("4135618175","Help me , i'm at "+ "http://maps.google.com/?q=<lat>,<lng>");
    	 //tracy
    	 sendSMS("4132109317","Help me , i'm at "+ "http://maps.google.com/?q=<lat>,<lng>");
    	 //izi
    	// sendSMS("5133757246","http://maps.google.com/?q=<lat>,<lng>");
    	 //kaya
    	 sendSMS("4134047340","Help me , i'm at "+ "http://maps.google.com/?q=<lat>,<lng>");
    	 
    	 //send SMS to added contact
    	 //sendSMS(s,"Help me , i'm at "+ "http://maps.google.com/?q=<lat>,<lng>");
    	 
    	 Log.d("message","sent");
    	 
    	 ll.clear();
    	 
    	 //record
    	   try {
    	         myAudioRecorder.prepare();
    	         myAudioRecorder.start();
    	      } catch (IllegalStateException e) {
    	         // TODO Auto-generated catch block
    	         e.printStackTrace();
    	      } catch (IOException e) {
    	         // TODO Auto-generated catch block
    	         e.printStackTrace();
    	      }
    	   
    	   Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();	  
    	   
    }else{
    	 //textarea2.setText("false");
    	 if(ll.size()==4)
    	    ll.clear();
    	}
   }
   
   
   //added for sms
   public void sendSMS( String phoneNo, String msg )
   {
       SmsManager sms = SmsManager.getDefault();
       sms.sendTextMessage( phoneNo, null, msg, null, null );
       
      
   }
   
    public void button1Clicked(){
    	
    	 btn1 = (Button) findViewById(R.id.btn1);
    	 btn1.setText("1");
    	 
         btn1.setOnClickListener( new View.OnClickListener() {
             public void onClick(View v)
             {
             	ll.addLast("1");
             	Log.d("ll",ll.size()+"ll size");
//             	 if(enterContact){
//            		   ll2.addLast("1");
//            		   Log.d("ll2",ll2.toString());
//            	   }
//                TextView textarea = (TextView)findViewById(R.id.text);
//            	textarea.setText(ll.toString());
            	
//            	TextView textarea2 = (TextView)findViewById(R.id.text2);
//            	textarea2.setText(ll2.toString());
            	
            	 checkPassword();
            	 checkPassword2();
            	 checkAlert();
            	// checkNumDigits();
            	
             }
         });
         
    }
    
    public void button2Clicked(){
    
    btn2 = (Button) findViewById(R.id.btn2);
    btn2.setText("2");
    btn2.setOnClickListener( new View.OnClickListener() {
        public void onClick(View v)
        {
        	ll.addLast("2");
//        	 if(enterContact){
//        		   ll2.addLast("2");
//        	   }
//        	 TextView textarea = (TextView)findViewById(R.id.text);
//          	textarea.setText(ll.toString());
          	
//          	TextView textarea2 = (TextView)findViewById(R.id.text2);
//        	textarea2.setText(ll2.toString());
        	
          	checkPassword();
          	checkAlert();
          	checkPassword2();
          //	checkNumDigits();
        }
    });
    }
    
    public void button3Clicked(){
        
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setText("3");
        btn3.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
            	ll.addLast("3");
//            	 if(enterContact){
//            		   ll2.addLast("3");
//            	   }
//            	TextView textarea = (TextView)findViewById(R.id.text);
//            	textarea.setText(ll.toString());
            	
//            	TextView textarea2 = (TextView)findViewById(R.id.text2);
//            	textarea2.setText(ll2.toString());
            	
            	 checkPassword();
            	 checkAlert();
            	 checkPassword2();
            	// checkNumDigits();
            	
            }
        });
        }
    
    public void button4Clicked(){
        
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setText("4");
        btn4.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
            	ll.addLast("4");
//            	 if(enterContact){
//            		   ll2.addLast("4");
//            	   }
//            	TextView textarea = (TextView)findViewById(R.id.text);
//            	textarea.setText(ll.toString());
            	
//            	TextView textarea2 = (TextView)findViewById(R.id.text2);
//            	textarea2.setText(ll2.toString());
            	
            	 checkPassword();
            	 checkAlert();
            	 checkPassword2();
            	// checkNumDigits();
            	
            }
        });
        }
    
    public void button5Clicked(){
        
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setText("5");
        btn5.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
            	ll.addLast("5");
//            	 if(enterContact){
//            		   ll2.addLast("5");
//            	   }
//            	TextView textarea = (TextView)findViewById(R.id.text);
//            	textarea.setText(ll.toString());
            	
//            	TextView textarea2 = (TextView)findViewById(R.id.text2);
//            	textarea2.setText(ll2.toString());
            	
            	 checkPassword();
            	 checkAlert();
            	 checkPassword2();
            	// checkNumDigits();
            	
            }
        });
    }
    
    
    
        public void button6Clicked(){
            
            btn6 = (Button) findViewById(R.id.btn6);
            btn6.setText("6");
            btn6.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v)
                {
                	ll.addLast("6");
//                	 if(enterContact){
//                		   ll2.addLast("6");
//                	   }
//                	TextView textarea = (TextView)findViewById(R.id.text);
//                	textarea.setText(ll.toString());
                	
//                	TextView textarea2 = (TextView)findViewById(R.id.text2);
//                	textarea2.setText(ll2.toString());
                	
                	 checkPassword();
                	 checkAlert();
                	 checkPassword2();
                	// checkNumDigits();
                }
            });
            
        }
        
        
        public void button7Clicked(){
            
            btn7 = (Button) findViewById(R.id.btn7);
            btn7.setText("7");
            btn7.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v)
                {
                	ll.addLast("7");
//                	 if(enterContact){
//                		   ll2.addLast("7");
//                	   }
//                	TextView textarea = (TextView)findViewById(R.id.text);
//                	textarea.setText(ll.toString());
                	
//                	TextView textarea2 = (TextView)findViewById(R.id.text2);
//                	textarea2.setText(ll2.toString());
                	
                	 checkPassword();
                	 checkAlert();
                	 checkPassword2();
                	// checkNumDigits();
                }
            });
            
        }
        
        
        
        public void button8Clicked(){
            
            btn8 = (Button) findViewById(R.id.btn8);
            btn8.setText("8");
            btn8.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v)
                {
                	ll.addLast("8");
                	
//                	 if(enterContact){
//                		   ll2.addLast("8");
//                	   }
//                	TextView textarea = (TextView)findViewById(R.id.text);
//                	textarea.setText(ll.toString());
                	
//                	TextView textarea2 = (TextView)findViewById(R.id.text2);
//                	textarea2.setText(ll2.toString());
                	
                	 checkPassword();
                	 checkAlert();
                	 checkPassword2();
                	// checkNumDigits();
                }
            });
            
        }
        
          
        
        public void button9Clicked(){
            
            btn9 = (Button) findViewById(R.id.btn9);
            btn9.setText("9");
            btn9.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v)
                {
                	ll.addLast("9");
                	
//                	 if(enterContact){
//                		   ll2.addLast("9");
//                	   }
//                	TextView textarea = (TextView)findViewById(R.id.text);
//                	textarea.setText(ll.toString());
                	
//                	TextView textarea2 = (TextView)findViewById(R.id.text2);
//                	textarea2.setText(ll2.toString());
                	
                	 checkPassword();
                	 checkAlert();
                	 checkPassword2();
                	// checkNumDigits();
                }
            });
            
        }
        
        
        
        public void button10Clicked(){
            
            btn10 = (Button) findViewById(R.id.btn10);
            btn10.setText("0");
            btn10.setOnClickListener( new View.OnClickListener() {
            	
                public void onClick(View v)
                {
                	ll.addLast("0");
                	
//                	 if(enterContact){
//              		   ll2.addLast("0");
//              	   }
                	
//                	TextView textarea = (TextView)findViewById(R.id.text);
//                	textarea.setText(ll.toString());
                	
//                	TextView textarea2 = (TextView)findViewById(R.id.text2);
//                	textarea2.setText(ll2.toString());
                	
                	
                	 checkPassword();
                	 checkAlert();
                	 checkPassword2();
                	// checkNumDigits();
                	 
                	 //stop audio recording after 0 is pressed 	
                	 try {
                		 
                		 myAudioRecorder.stop();
                         myAudioRecorder.release();
                         myAudioRecorder  = null;
                         
 					} catch (IllegalArgumentException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					} catch (SecurityException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					} catch (IllegalStateException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                     
          Toast.makeText(getApplicationContext(), "Audio recorded", Toast.LENGTH_LONG).show();
       
                    ll.clear();
                	}
                
            });
        
        
        }
        
//       public boolean checkContactSave(){
//    	   
//    	   if(ll.size()!=3){
//    		   return false;
//    	   }
//           for(int i=0; i<3; i++){
//        	if(ll.get(i)=="1"){
//        		Log.d(ll.toString(),ll2.toString());
//        	}	
//        	else{
//        		return false;
//        	}
//           }
//
//           ll.clear();
//           enterContact =true;
//           return true;
//           
//
//        }
       
       
//       public void checkNumDigits(){
//    	  
//    	   Log.d("ll2",ll2.size()+"ll2 size");
//    	   if(ll2.size()==10){
//    		   s=ll2.toString();
//    		   Log.d(ll.toString(),ll2.toString());
//           	TextView textarea = (TextView)findViewById(R.id.text);
//           	textarea.setText(ll2.toString());
//    		   
//    		   Toast.makeText(getApplicationContext(), "contact saved", Toast.LENGTH_LONG).show();
//    	   }
//    	   
//       }
           
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
