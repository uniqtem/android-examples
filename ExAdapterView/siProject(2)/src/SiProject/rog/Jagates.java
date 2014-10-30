package SiProject.rog;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Jagates extends Activity implements OnClickListener  {
	Button bt1,bt2,bt3;
	TextView tv;
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
    requestWindowFeature(Window.FEATURE_NO_TITLE); 
	super.onCreate(savedInstanceState);
	setContentView(R.layout.jaga);
	tv = (TextView)this.findViewById(R.id.tv);
	tv.setText("\n  1. 화장실에 갈 때 스마트폰을 사용한다\n\n"+
			"  2. 주머니에 스마트폰이 없으면 패닉상태에 빠진다\n\n"+
"  3. 스마트폰 사용자끼리 만났을 때 스마트폰 이야기만 한다\n\n"+
"  4. 스마트폰이 고장나면 친구를 잃은 것 같은 느낌이 든다\n\n"+
"  5. 충전한 배터리가 하루 동안 지속되기 힘들다\n\n"+
"  6. 스마트폰 요금을 지불하기 위해 생활비를 줄인다\n\n"+
"  7. 내 스마트폰에 관한 것을 스마트폰을 통해 알아본다\n\n"+
"  8. 하루의 모든 일정이 모두 스마트폰 안에 저장돼 있다\n\n"+
"  9. 스마트폰에 앱이 30개 가량 설치 돼 있고, 그것을 모두 사용한다\n\n"+
"  10. 스마트폰 악세서리 구입에 스마트폰 가격보다 더 많은 돈을 쓴다\n\n");
	bt1 = (Button)this.findViewById(R.id.but1);
	bt1.setOnClickListener(this);
	bt2 = (Button)this.findViewById(R.id.but2);
	bt2.setOnClickListener(this);
	bt3 = (Button)this.findViewById(R.id.but3);
	bt3.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.but1:
			tv.setText("0개 ~ 3개 \n정상입니다.");
			tv.setTextSize(40.0f);
			tv.setGravity(Gravity.CENTER_VERTICAL);
			
			bt1.setVisibility(View.INVISIBLE);
        	bt2.setVisibility(View.INVISIBLE);
        	bt3.setVisibility(View.INVISIBLE);
		break;
		case R.id.but2:
			tv.setText("0개 ~ 3개 \n중독 초기 증세입니다.");
			tv.setTextSize(40);
		
			tv.setTextColor(0xFF0000ff);
			bt1.setVisibility(View.INVISIBLE);
        	bt2.setVisibility(View.INVISIBLE);
        	bt3.setVisibility(View.INVISIBLE);
			break;
		case R.id.but3:
			tv.setText("8개 ~ 10개 \n완전 중독 상태입니다.");
			tv.setTextSize(40);
		
			tv.setTextColor(0xFFff0000);
			bt1.setVisibility(View.INVISIBLE);
        	bt2.setVisibility(View.INVISIBLE);
        	bt3.setVisibility(View.INVISIBLE);
			break;
		}
		
	}

	
}

