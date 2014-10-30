package SiProject.rog;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Alim2 extends Activity {
	//static final String[] body = { "스마트폰 이용시 눈 건강법", "거북목증후군", "손가락 손목 통증",
	//		"눈 건조증 유발", "항문 질환"};
	int mLastAction;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alim);

		ArrayList<MyItem> arrayItems=new ArrayList<MyItem>();
		
        arrayItems.add(new MyItem(R.drawable.a1,"  거북목 증후군","   핸드폰 액정은 우리 눈높이보다..."));
        arrayItems.add(new MyItem(R.drawable.a2,"  손가락 손목 통증","   오래 핸드폰을 터치하다보면..."));
        arrayItems.add(new MyItem(R.drawable.a3,"  눈 건조증 유발","   작은 액정을 보기 위해 눈에 힘을..."));
        arrayItems.add(new MyItem(R.drawable.a4,"  항문 질환","   요즘 화장실에 갈 때 신문 대신..."));
        arrayItems.add(new MyItem(R.drawable.a5,"  노안 급증","   스마트폰이 대중화되면서 이에..."));
        
        CustomAdater adapter = new CustomAdater(this,R.layout.itemlayout,arrayItems);     
        ListView list = (ListView)this.findViewById(R.id.listview1);
        list.setAdapter(adapter);  
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				AlertDialog.Builder d = new AlertDialog.Builder(Alim2.this);
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					d.setTitle("거북목 증후군");
					d.setMessage("핸드폰 액정은 우리 눈높이보다 낮기 때문에 액정을 보려면 자연스럽게 목이 구부정해져요.\n\n" +
							" 목이 구부정하게 되면서 정상적인 목뼈의 C자가 아닌 일자 형태로 변형이 되면서 거북목 증후군 증상이 나타나기도 하는데요.\n\n" +
							" 이러한 자세를 오래 유지하다보면 심하게는 목디스크에 걸릴 수도 있으니 조심해야 합니다.\n\n" +
							" 목의 스트레스를 줄이려면 스마트폰은 가슴 높이 이상으로,\n\n" +
							" 눈과의 거리는 30cm를 유지하시고 똑같은 자세를 10분 이상 지속하지 않도록 수시로 자세를 바꿔주시는게 좋아요.");
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 1:
					d.setTitle("손가락 손목 통증");
					d.setMessage("오래 핸드폰을 터치하다보면 손가락이 저리는 증상이 오기도 하지 않나요? \n\n" +
							"특히 스마트폰은 작은 키보드의 형식으로 되어 있기 때문에 세심하게 타자를 치다 보면 금방 손목과 손가락이 찌릿찌릿하죠. \n\n" +
							"이 경우에는 손목터널 증후군이 나타날 수 있으니 조심해야 해요.\n\n " +
							"손목이나 손가락을 과도하게 사용해 팔에서 손으로 가는 신경이 눌려 손이 저리거나 감각이 둔해지게 되어 통증을 유발할 수 있답니다.\n\n" +
							" 원래는 주부에게 많이 나타나는 질병이였다고 하는데, 요즘엔 컴퓨터 사용이 많은 직장인들, 청소년에게도 많이 나타난다고 해요.\n\n" +
							" 손목이나 손가락에 통증이 느껴지면 사용을 중단하고, 가볍게 스트레칭을 해주세요. \n\n" +
							"따뜻한 물에 손을 담궈 주먹을 쥐었다 피기를 5~10분 정도 해주시는것도 좋아요.");
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 2:
					d.setTitle("눈 건조증 유발");
					d.setMessage("작은 액정을 보기 위해 눈에 힘을 집중해주기 때문에 눈을 깜빡이는 횟수가 줄어들게 되고 그렇게 되면 눈이 쉽게 건조해집니다.\n\n " +
							"눈이 건조하면 피로감이 심해지거나 이물감 때문에 아프기도 하죠.\n\n " +
							"이로 인해 안구 건조증과 같은 안구 질환에 걸릴 확률이 아주 높아요.\n\n " +
							"그러니 되도록이면 화면을 오랜 시간동안 보지 마시고, 자주 먼 곳을 바라보거나 눈을 깜빡여 눈이 건조해지는 것을 막아주세요.\n\n " +
							"물을 자주 마시거나 화면의 글자를 키워 보기. 화면 밝기 조정등으로 눈을 보호해주세요.");
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 3:
					d.setTitle("항문 질환");
					d.setMessage("요즘 화장실에 갈 때 신문 대신 스마트폰을 들고 가서 활용하는 경우가 많습니다. \n\n" +
							"무심코 변기에 앉아 이것저것 프로그램을 돌리면서 자신도 모르게 배변 시간이 늘어납니다. \n\n" +
							"변기에 오래 앉아 있으면 피가 항문으로 몰려서 혈관이 늘어납니다. \n\n" +
							"이것이 자주 반복되면 늘어난 혈관이 터지거나 원상태로 회복되지 않아 훙문 밖으로 나옵니다.\n\n" +
							" 이를 막기 위해서는 우선 화장실에 갈 때 가급적 스마트폰을 들고 가지 않는 것이 좋아요. \n\n" +
							"불가능하다면 의식적으로 10분안에 배변을 끝내고 나와야 해요.");
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 4:
					d.setTitle("노안 급증");
					d.setMessage("국내 스마트폰 가입자가 1000만명 이상 중 20~30대 비율이 60%를 돌파 했어요 \n\n" +
							"스마트폰이 대중화되면서 이에 따른 부작용도 많이 있죠. 특히 최근에는 스마트폰과 태블릿 PC 등의 휴대용 디지털기기의 과도한 사용으로 30대 젊은층 노안 환자가 급증한다네요. \n\n" +
							"이에 원인은 흔들리는 버스나 지하철에서 스마트폰으로 신문을 보거나 e메일 등을 체크하는 습관이 원인이라고 하네요\n\n" +
							"일반적으로 스마트폰 화면에 떠 있는 글씨 등을 들여다볼 때 1분당 눈을 깜빡이는 횟수는 약 5회 정도 된데요 하지만 사람들이 일상생활을 할때 15~20회 정도 눈을 깜빡인데요 이는 눈을 나쁘게 만들죠\n\n" +
							"노안을 예방하기 위해서는 무엇보다 작은 글씨를 읽을 때 주의해야 해요. 조명은 약 400∼700룩스(백열등 한 개에 스탠드형광등을 함께 사용하는 정도)를 유지하며, " +
							"버스나 지하철같이 흔들리는 곳에서는 책을 읽지 말고 TV를 볼 때는 불을 켜고 보는 것이 좋아요.\n\n4" +
							"평소 눈을 쉬게 하는 것도 중요해요. 장시간 컴퓨터 작업을 하거나 근거리 작업을 할 때는 1시간마다 5분 정도 눈을 감고 휴식을 취하고, \n\n" +
							"눈에 피곤함이 느껴진다면 눈을 감고 안구를 천천히 안구를 돌리면 도움이 된데요. 멀리 떨어진 산을 바라보는 것도 눈의 피로를 풀 수 있는 좋은방법이고요.");
							
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				}
			}
		
        
        });
	}

		//ArrayAdapter adapter = new ArrayAdapter(this,
		//		android.R.layout.simple_list_item_1, body);
		//final ListView list = (ListView) this.findViewById(R.id.listview1);
		//list.setAdapter(adapter);   
        //setContentView(R.layout.alim);
     /*   ArrayList<MyItem> arrayItems2=new ArrayList<MyItem>();

        CustomAdater adapter2 = new CustomAdater(this,R.layout.itemlayout,arrayItems2);
       
        list = (ListView)this.findViewById(R.id.listview2);
        list.setAdapter(adapter2);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				// TextView text = (TextView)findViewById(R.id.li)
				AlertDialog.Builder d = new AlertDialog.Builder(Alim.this);
				switch (arg2) {
			
				}

			}

		});
		
	}
	*/
	/*@Override
	   public boolean dispatchTouchEvent(MotionEvent ev)
       {
               int action = ev.getAction();

              // boolean mbIsScrollEnabled = false;

                       //int mLastAction = 0;
					if (action == mLastAction) {
                               ev.setAction(MotionEvent.ACTION_CANCEL);
                               super.dispatchTouchEvent(ev);
                               return true;
                       }
                       mLastAction = action;


               return super.dispatchTouchEvent(ev);
       }*/
}



