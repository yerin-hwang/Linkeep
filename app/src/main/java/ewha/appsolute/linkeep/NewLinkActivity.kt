package ewha.appsolute.linkeep

import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_new_link.*

class NewLinkActivity : AppCompatActivity() {

    private val constGetGalleryImage = 200
    private val constSearchHashTag = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_link)

        val paste: Button = new_btn_paste_link
        paste.setOnClickListener {
            //클립보드 처리
            var clipboard: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

            if (!(clipboard.hasPrimaryClip())) {
                //데이터가 없거나 텍스트 타입이 아닌 경우
            } else {
                //클립보드에서 젤 앞의 문자열 가져옴
                var item = clipboard.primaryClip?.getItemAt(0)
                var pasteData = ""
                if (item != null) {
                    pasteData = item.text.toString()
                }

                //문자열 교체
                new_text_edit_link.setText(pasteData as CharSequence)
                //알림 메시지
                var myMessage = "붙여넣기 완료"//R.string.new_btn_paste
                Toast.makeText(this, myMessage as CharSequence, Toast.LENGTH_SHORT)
                    .show()
            }
        }


        //해시태그 recycler view
        supportFragmentManager.beginTransaction().run {
            replace(R.id.new_recyclerview, HashtagRecyclerViewFragment())
            commit()
        }

        val addHashtag: Button = findViewById(R.id.new_btn_add_hashtag)
        addHashtag.setOnClickListener {
            //search 화면
            val next = Intent(this, SearchActivity::class.java)
            startActivityForResult(next, constSearchHashTag)
        }

        val gallery: ConstraintLayout = findViewById(R.id.new_btn_gallery)
        gallery.setOnClickListener {
            //갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            startActivityForResult(intent, constGetGalleryImage)
        }

        val webpage: ConstraintLayout = findViewById(R.id.new_btn_web_page)
        webpage.setOnClickListener {
            //웹뷰 호출

        }

        val add: ConstraintLayout = findViewById(R.id.new_btn_add)
        add.setOnClickListener {
            //모든 항목 입력 validation
            //1. 링크
            //2. 해시태그 1개 이상
            //3. 이미지 (기본 이미지 넣어 놓기)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == constGetGalleryImage && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val selectedImageUri: Uri? = data.data
            new_img_thumbnail.setImageURI(selectedImageUri)
        }
    }
}
