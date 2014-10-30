package Ex03_RadioGroup.org;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Ex03_RadioGroupActivity extends Activity implements
		OnCheckedChangeListener,
		android.widget.CompoundButton.OnCheckedChangeListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		RadioGroup rd = (RadioGroup) this.findViewById(R.id.radiogroup1);
		rd.setOnCheckedChangeListener(this);
		CheckBox cb = (CheckBox) this.findViewById(R.id.check);
		cb.setOnCheckedChangeListener(this);

	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		ImageView iv = (ImageView) this.findViewById(R.id.image);
		switch (arg1) {
		case R.id.radio1:
			iv.setImageResource(R.drawable.picture1);
			break;
		case R.id.radio2:
			iv.setImageResource(R.drawable.picture2);
			break;
		case R.id.radio3:
			iv.setImageResource(R.drawable.picture3);
			break;
		}

	}

	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		ImageView iv = (ImageView) this.findViewById(R.id.image);
		// Matrix matrix = new Matrix();
		// matrix.postScale(100, 1, mid.x, mid.y);
		// ImageView.setImageMatrix(matrix);
		// ImageView.invalidate();
		int maxHeight = 90, maxWidth = 90;

		if (arg1) {
			Toast.makeText(this, "확대를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			iv.setAlpha(1000);

		} else {
			Toast.makeText(this, "축소를 선택하셨습니다.", Toast.LENGTH_SHORT).show();
			iv.setAlpha(0);
		}

	}
}