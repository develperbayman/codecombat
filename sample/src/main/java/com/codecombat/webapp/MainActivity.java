package com.codecombat.webapp;



import android.annotation.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import com.codecombat.webapp.webview.AdvancedWebView.*
//import com.codecombat.webapp.*;
//import im.delight.android.webview.*;
//import com.codecombat.webapp.R.*;

public class MainActivity extends Activity implements AdvancedWebView.Listener {

	private static final String TEST_PAGE_URL = "http://www.codecombat.com";
	private AdvancedWebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		
		setContentView(R.layout.activity_main);

		mWebView = (AdvancedWebView) findViewById(R.id.webview);
		mWebView.setListener(this, this);
		mWebView.setGeolocationEnabled(false);
		mWebView.setMixedContentAllowed(true);
		mWebView.setCookiesEnabled(true);
		mWebView.setThirdPartyCookiesEnabled(true);
		mWebView.setWebViewClient(new WebViewClient() {

			@Override
			public void onPageFinished(WebView view, String url) {
				Toast.makeText(MainActivity.this, "Finished loading", Toast.LENGTH_SHORT).show();
			}

		});
		mWebView.setWebChromeClient(new WebChromeClient() {

			@Override
			public void onReceivedTitle(WebView view, String title) {
				super.onReceivedTitle(view, title);
				Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
			}

		});
		mWebView.addHttpHeader("X-Requested-With", "");
		mWebView.loadUrl(TEST_PAGE_URL);
	}

	@SuppressLint("NewApi")
	@Override
	protected void onResume() {
		super.onResume();
		mWebView.onResume();
		// ...
	}

	@SuppressLint("NewApi")
	@Override
	protected void onPause() {
		mWebView.onPause();
		// ...
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		mWebView.onDestroy();
		// ...
		super.onDestroy();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		mWebView.onActivityResult(requestCode, resultCode, intent);
		// ...
	}

	@Override
	public void onBackPressed() {
		if (!mWebView.onBackPressed()) { return; }
		// ...
		super.onBackPressed();
	}

	@Override
	public void onPageStarted(String url, Bitmap favicon) {
		mWebView.setVisibility(View.INVISIBLE);
	}

	@Override
	public void onPageFinished(String url) {
		mWebView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onPageError(int errorCode, String description, String failingUrl) {
		Toast.makeText(MainActivity.this, "onPageError(errorCode = "+errorCode+",  description = "+description+",  failingUrl = "+failingUrl+")", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
		Toast.makeText(MainActivity.this, "onDownloadRequested(url = "+url+",  suggestedFilename = "+suggestedFilename+",  mimeType = "+mimeType+",  contentLength = "+contentLength+",  contentDisposition = "+contentDisposition+",  userAgent = "+userAgent+")", Toast.LENGTH_LONG).show();

		/*if (AdvancedWebView.handleDownload(this, url, suggestedFilename)) {
			// download successfully handled
		}
		else {
			// download couldn't be handled because user has disabled download manager app on the device
		}*/
	}

	@Override
	public void onExternalPageRequest(String url) {
		Toast.makeText(MainActivity.this, "onExternalPageRequest(url = "+url+")", Toast.LENGTH_SHORT).show();
	}
	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {

		super.onCreateOptionsMenu(menu);


        //menu.add (Menu.NONE, 0, Menu.NONE,("Html5,Css3,JavaScript Creator"));
		//  menu.add(Menu.NONE, 1, Menu.NONE, ("English Html5,Html4,Css Creator"));
		// menu.add(Menu.NONE, 2, Menu.NONE,("Open File"));
		//	menu.add(Menu.NONE, 3, Menu.NONE,("Save"));
		// menu.add(Menu.NONE, 4, Menu.NONE,("Load"));
		//	menu.add(Menu.NONE, 5, Menu.NONE,("Preview WebPage"));
		// menu.add(Menu.NONE, 6, Menu.NONE,("Css3 Editor"));
		//menu.add(Menu.NONE, 7, Menu.NONE,("JavaScript Editor"));
		//	menu.add(Menu.NONE, 8, Menu.NONE,("WebServer Control Menu"));
		menu.add(Menu.NONE, 9, Menu.NONE,("OK"));
        return true;
    } // end onCreateOptionsMenu()

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:


              //  Intent intent0 = new Intent(this, FirstActivity.class);
               // startActivity(intent0);


                return true;
            case 1:
				//	Intent intent1 = new Intent(this, SecondActivity.class);
				// startActivity(intent1);

                return true;
            case 2:


                return true;
            case 3:


                return true;
            case 4:


                return true;
            case 5:

				//	Intent intent = new Intent(this, WebBrowserActivityHtml5.class);
				//	startActivity(intent);

                return true;
            case 6:
				//   Intent intent = new Intent(this, Html5Main.class);
				//     startActivity(intent);

                return true;
            case 7:

				//	Intent intent7 = new Intent(this, JavaScriptEditor.class);
				//	startActivity(intent7);



                return true;
            case 8:

				// Intent intent8 = new Intent(this, StartActivity.class);
				//  startActivity(intent8);

                return true;
            case 9:

				//Intent intent9 = new Intent(this, FirstActivity.class);
				//startActivity(intent9);
				//	finish();
                return true;


        }
        return false;
    }
	

}
