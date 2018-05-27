package com.example.silver.ungdungdocsach.activity;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.adapter.ChuongAdapter;
import com.example.silver.ungdungdocsach.adapter.TapAdapter;
import com.example.silver.ungdungdocsach.model.ChuongMod;
import com.example.silver.ungdungdocsach.model.TruyenMod;

import java.util.ArrayList;

public class Chuong extends AppCompatActivity {
    ListView lvChuong;
    ArrayList<ChuongMod> arraySoChuong = new ArrayList<>();
    ChuongAdapter adapter;
    private String text []={"Chương 1","Chương 2","Chương 3","Chương 4","Chương 5","Chương 6","Chương 7","Chương 8","Chương 9","Chương 10","Chương 11",};
    SQLite db;
    int idtap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong);
        idtap = getIntent().getIntExtra("matap",-1);

        lvChuong=(ListView)findViewById(R.id.lvChuong);

        getData();

        adapter=new ChuongAdapter(this,R.layout.dong_so_chuong, arraySoChuong);
        lvChuong.setAdapter(adapter);
        lvChuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                Intent intentsotap= new Intent(Chuong.this, Truyen.class);

                int sql =  (position+1);
                int sql2 = idtap ;
                intentsotap.putExtra("chuong",sql);
                intentsotap.putExtra("tap",sql2);
                startActivity(intentsotap);
            }
        });

    }

    private void getData(){
        db = new SQLite(this,"cuoiki1",null,1);

        if(idtap!=-1) {

            Cursor cursorChuong = db.GetData("SELECT * FROM TruyenMod");
            if(cursorChuong.getCount()==0) {
                setData();
            }
            cursorChuong = db.GetData("SELECT * FROM ChuongMod WHERE MaTap = "+idtap);
            while (cursorChuong.moveToNext()){
                int id_chuong = cursorChuong.getInt(0);
                String ten_chuong = cursorChuong.getString(1);
                int ma_tap = cursorChuong.getInt(2);
                ChuongMod chuong = new ChuongMod(id_chuong,ten_chuong,ma_tap);
                arraySoChuong.add(chuong);
            }
        }
    }
    private void setData(){

            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Giá trị của thử thách','Một con tằm phải trải qua đau đớn để tự chui ra khỏi cái kén và trưởng thành con bướm biết bay.\n" +
                    "\n" +
                    "Một hạt giống nằm sâu trong lòng đất để nảy mầm phải tự vươn thẳng lên xuyên qua tầng đất dày và trở thành cây cứng cáp.\n" +
                    "\n" +
                    "Con tằm nào được người ta cắt vỏ kén chui ra mãi mãi bò quẩn quanh cái kén mà không bao giờ thành loài bướm biết bay.\n" +
                    "\n" +
                    "Hạt giống nằm trên mặt đất dễ dàng nảy mầm nhưng sẽ bị bật gốc khi gặp cơn dông tố.\n" +
                    "\n" +
                    "Con người không thể chọn cho mình nơi sinh ra, nhưng có thể tự chọn cho mình một cách sống; rèn luyện cho mình khả năng chịu đựng và bản lĩnh ý chí qua thử thách, khó khăn, bất hạnh và cả thất bại. Thất bại, bất hạnh có thể là điều tuyệt vọng với người này nhưng có thể là may mắn với người khác - tùy vào cách chúng ta đón nhận bằng cách dũng cảm vượt qua hay tự thương thân trách phận mà gục ngã.',1,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đến một ngày...','Đến một ngày chúng ta bỗng nhận ra nhiều điều của cuộc sống, như một căn duyên chợt đến để cảm nhận - theo lời người xưa từng nói là ngộ ra.\n" +
                    "\n" +
                    "Chúng ta bỗng nhận ra sự xuyên suốt lẽ ra phải có trong cuộc sống mình - khi trời đất tĩnh lặng, khi lòng người lắng xuống tận đáy ký ức tâm hồn. Chúng ta chợt thấy những ngày đã qua dù làm được nhiều việc nhưng chỉ là một quán tính của sự cảm nhận cùng lòng say mê chiến thắng và sự tự khẳng định mình.\n" +
                    "\n" +
                    "Một lúc nào đó chúng ta bỗng nhận ra sự vô tình của bản thân với những giá trị khác và những tấm chân tình của người bạn đã xa. Chúng ta thường nhận ra sự chưa hoàn thiện của người khác mà quên đi của chính mình - khi bản ngã kiêu hãnh và cái tôi chen chân đứng cùng một chỗ, khi chúng ta tự cho tầm nhìn của mình là rộng nhất.\n" +
                    "\n" +
                    "Chúng ta chợt cảm nhận được quy luật sâu xa của cuộc sống là quá trình cho và nhận. Chúng ta cảm thấy sự tha thứ, bao dung, nhìn nhận lại cũng là một sự cho đi và những tổn thương tinh thần tưởng chừng không có nguồn nào bù đắp trở nên nhẹ nhàng như cần phải có.\n" +
                    "\n" +
                    "Chúng ta chợt cảm thấy sự thanh thản, nhẹ nhàng trước những nỗi đau, lỗi lầm, mất mát của ngày hôm qua, sự mới mẻ tinh khôi của ngày hôm nay và đó chính là những gì dành cho ngày mai.\n" +
                    "\n" +
                    "Có lúc chúng ta nhận ra bầu trời lấp lánh ngàn vì sao hay đen kịt âm u dông tố không ngăn được sự bừng sáng của một con tim - ánh sáng rực rỡ của mặt trời chiếu rọi không ấm áp bằng chiếc đèn lồng ký ức tình yêu, và hạnh phúc không phải chỉ là nụ cười mà còn là giọt nước mắt trên bờ vai tin cậy.\n" +
                    "\n" +
                    "Đến một lúc chúng ta cảm thấy sự thừa thãi của ngôn từ, sự ấm lòng của tình thương thầm lặng, ý nghĩa của sự chia sẻ và điểm thiêng liêng trong sáng của ánh mắt ai đó chợt nhìn ta. Chúng ta cảm nhận được sợi dây kết nối mọi người, điểm tĩnh trong chuyển động, sự trường tồn của cuộc sống và chợt thấy khoảnh khắc của ngày hôm nay ý nghĩa hơn ngày hôm qua.',2,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tin tốt lành','Ý nghĩa cuộc sống không phải ở chỗ nó đem đến cho ta điều gì, mà ở chỗ ta có thái độ đối với nó ra sao; không phải ở chỗ điều gì xảy ra với ta, mà ở chỗ ta phản ứng với những điều đó như thế nào.\n" +
                    "\n" +
                    "- Lewis L. Dunnington\n" +
                    "\n" +
                    "Một anh sinh viên vừa tốt nghiệp đại học đang tìm việc làm đã tham dự một cuộc thi sáng tạo chuyên ngành do liên hiệp các trường đại học trong cả nước tổ chức. Sau nhiều vòng sơ khảo kéo dài cả tháng trời, anh được lọt vào nhóm những người xuất sắc nhất để dự vòng thi chung kết. Rồi anh cũng vất vả vượt qua các đối thủ trong cuộc đấu trí cuối cùng, kéo dài ba ngày liền căng thẳng và giành được giải nhất. Phần thưởng cho anh là một món tiền khá lớn mà cuộc đời sinh viên trước nay của anh chưa từng mơ ước tới. Sau khi rời hội trường và trốn nhanh khỏi ánh đèn camera của báo giới, anh vào bãi lấy xe ra về. Bất ngờ một phụ nữ tiến đến gần anh. Bà nghẹn ngào:\n" +
                    "\n" +
                    "- Chú ơi! Chúc mừng chú, thật vinh dự cho chú đã đạt được giải nhất trong cuộc thi khó khăn này. Tôi có một chuyện muốn nói với chú nhưng không biết có tiện không. Nếu chú có con nhỏ chú mới hiểu được điều tôi sắp nói. Con của tôi bị ung thư và đang nằm trong bệnh viện, nếu không có một khoản tiền để mổ, chắc em nó không qua khỏi được! Mà nhà tôi thì... không thể lo được một khoản tiền lớn đến như vậy...\n" +
                    "\n" +
                    "- Thế bác cần bao nhiêu? - Anh sinh viên nhìn bà hỏi, lòng cảm thông thật sự.\n" +
                    "\n" +
                    "Sau khi nghe người phụ nữ kể hết sự việc, anh liền lấy chiếc phong bì đựng số tiền vừa được thưởng và trao cho bà.\n" +
                    "\n" +
                    "- Cầu mong cho con bác qua được hiểm nguy. Bác về lo cho em ấy ngay đi. - Anh nói.\n" +
                    "\n" +
                    "- Cảm ơn chú, không biết tôi phải lấy gì mà đền ơn chú đây.\n" +
                    "\n" +
                    "Nói rồi người phụ nữ với vẻ xúc động quày quả bước ra cổng.\n" +
                    "\n" +
                    "Vài ngày sau anh có dịp quay lại trường. Một người trong thấy liền tiến tới hỏi:\n" +
                    "\n" +
                    "- Có người kể với tôi rằng tối hôm trước anh có gặp một người phụ nữ sau cuộc thi và anh đã cho bà ấy tiền để chữa bệnh cho đứa con sắp chết của bà ấy, phải không?\n" +
                    "\n" +
                    "Người thanh niên gật đầu xác nhận.\n" +
                    "\n" +
                    "- Vậy thì tôi phải báo với anh tin này để anh biết. Bà ta là một tay lừa đảo thật sự đấy. Bà ta chẳng có đứa con nào bị bệnh gần chết cả. Anh cả tin quá! Anh bị lừa rồi, anh bạn ạ!\n" +
                    "\n" +
                    "Một thoáng im lặng, anh thanh niên hỏi lại:\n" +
                    "\n" +
                    "- Có thật là không có đứa bé nào bị bệnh gần chết cả, đúng không?\n" +
                    "\n" +
                    "- Đúng vậy. Tôi bảo đảm là như thế. - Người đàn ông quả quyết.\n" +
                    "\n" +
                    "- Ô, đó là tin tốt lành nhất trong ngày mà tôi được biết đấy. - Người thanh niên nói.\n" +
                    "\n" +
                    "Đoạn anh nói thêm:\n" +
                    "\n" +
                    "- Chúng ta nên ăn mừng vì không có đứa trẻ nào phải chết cả.',3,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Không đề','Một cô gái trẻ gặp phải những nỗi đau thương, tuyệt vọng lớn trong cuộc sống một thời gian dài mà không sao nguôi ngoai được. Một buổi sáng cô quyết định tìm đến cái chết cho lòng nhẹ nhàng thanh thản hơn. Cô đi đến một cây cầu bắc qua dòng sông sâu, cô nhìn thật lâu xuống dòng nước cuộn trào vô tình như bị thôi miên và sắp sửa nhảy xuống thì chợt nghe tiếng nói chậm rãi của một cụ già vang lên bên cạnh:\n" +
                    "\n" +
                    "- Cháu định nhảy xuống ư? Cháu nên về nhà chào mẹ cháu một câu rồi quay lại cũng chẳng muộn mà!\n" +
                    "\n" +
                    "Nói rồi ông lão cầm cần câu thong thả đi về phía đầu cầu không ngoái lại.',4,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cội rễ của sự trưởng thành','Sức mạnh của con người định hình trong chính sự yếu đuối của người ấy.\n" +
                    "\n" +
                    "- Ralph Waldo Emerson\n" +
                    "\n" +
                    "Hồi còn nhỏ, tôi có một người hàng xóm mà mọi người gọi là bác sĩ Gibbs. Ông không giống như bất kỳ bác sĩ nào tôi từng biết, ông rất giản dị và hiền từ, nhất là đối với bọn nhóc nghịch ngợm chúng tôi.\n" +
                    "\n" +
                    "Ngoài giờ làm công việc cứu người, bác sĩ Gibbs thường trồng cây. Ông muốn biến mảnh đất rộng 10 mẫu tây của mình thành một khu rừng mà! Vị bác sĩ hiền lành ấy có những lý thuyết trồng cây rất thú vị, ngược hẳn với nguyên tắc mà mọi người cho là hiển nhiên. Không bao giờ ông tưới nước cho những cây mới sinh trưởng - ông giải thích với tôi rằng tưới nước sẽ làm chúng sinh ra hư hỏng, và thế hệ cây kế tiếp sẽ ngày một yếu đi. Vì thế cần phải tập cho chúng đối mặt với khắc nghiệt. Cây nào không chịu nổi sẽ bị nhổ bỏ ngay từ đầu.\n" +
                    "\n" +
                    "Rồi ông hướng dẫn cho tôi cách tưới nước cho những cây rễ mọc trên cạn, để khi khô hạn thì chúng sẽ phải tự bén rễ sâu mà tìm nguồn nước. Thảo nào, chẳng bao giờ tôi thấy ông tưới cây cả. Ông trồng một cây sồi, mỗi tháng thay vì tưới nước, ông lấy tờ báo cuộn tròn lại và đập vào nó: Bốp! Bốp! Bốp! Tôi hỏi ông tại sao lại làm vậy thì ông trả lời: để làm nó chú ý.\n" +
                    "\n" +
                    "Bác sĩ Gibbs từ giã cõi đời hai năm sau khi tôi xa gia đình. Giờ đây, về nhìn lại những hàng cây nhà ông, tôi lại như mường tượng ra dáng ông đang trồng cây 25 năm về trước. Những thân cây ngày ấy nay đã lớn mạnh và tràn trề sức sống. Như những thanh niên cường tráng, mỗi sáng chúng thức dậy, tự hào ưỡn ngực và sẵn sàng đón nhận những gian nan, thử thách.\n" +
                    "\n" +
                    "Vài năm sau tôi cũng tự trồng lấy hai cây xanh. Mùa hè cháy nắng tôi tưới nước; mùa đông giá rét tôi bơm thuốc và cầu nguyện cho chúng. Chúng cao gần chín mét sau hai năm, nhưng lại là những thân cây luôn dựa dẫm vào bàn tay người chăm bẵm. Chỉ cần một ngọn gió lạnh lướt qua, chúng đã run rẩy và đánh cành lập cập - trông chẳng khác gì những kẻ yếu đuối!\n" +
                    "\n" +
                    "Chẳng bù với rừng cây của bác sĩ Gibbs. Xem ra nghịch cảnh và thiếu thốn dường như lại hữu ích cho chúng hơn sự đầy đủ.\n" +
                    "\n" +
                    "Hằng đêm trước khi đi ngủ, tôi thường ghé phòng hai đứa con trai và ngắm nhìn chúng ngủ ngon lành. Nhìn thân thể nhỏ bé đang phập phồng nhịp thở của cuộc sống, tôi luôn cầu nguyện cho chúng có một cuộc sống dễ chịu.\n" +
                    "\n" +
                    "Nhưng gần đây, tội chợt nghĩ đã đến lúc cần phải thay đổi lời nguyện cầu ấy. Tôi nguyện cầu cho chúng mạnh mẽ hơn, để chịu được dông gió không thể tránh trong cuộc đời. Có ngây thơ mới mong chúng thoát khỏi gian khổ - bởi lẽ nghịch cảnh, khó khăn luôn là điều hiện hữu tất yếu. Và dù muốn hay không, cuộc đời chẳng bao giờ bằng phẳng cả. Tôi cầu mong cho “gốc rễ” của con mình sẽ bén thật sâu, để chúng có thể hút được sức mạnh từ những suối nguồn tiềm ẩn trong cuộc sống.\n" +
                    "\n" +
                    "Thật sự nhìn lại, tôi đã cầu xin sự an lành quá nhiều rồi, nhưng rất hiếm khi những ước muốn ấy được thỏa nguyện. Điều chúng ta cần là mong sao cho mình rèn luyện được một cơ thể cường tráng và ý chí cứng cỏi, bền vững, để khi nắng cháy hay mưa dông, bão tố, chúng ta sẽ không bao giờ bị gục ngã.',5,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đừng bao giờ từ bỏ ước mơ','Ước mơ không phải là cái sẵn có, cũng chẳng phải là cái không thể có. Ước mơ chính là những con đường chưa định hình nhưng rồi con người sẽ hướng tới và vượt qua.\n" +
                    "\n" +
                    "Ngày đầu tiên của năm học, vị giáo sư môn hóa của lớp tôi tự giới thiệu mình với sinh viên trong lớp rồi dành thì giờ cho chúng tôi làm quen với nhau. Đương lúc tôi đứng dậy nhìn xung quanh thì nhận thấy có một bàn tay dịu dàng đặt lên vai mình. Tôi xoay người lại, đó là một bà cụ có vóc dáng nhỏ bé, làn da nhăn nheo, đang nhìn tôi với nụ cười làm sáng cả gương mặt bà.\n" +
                    "\n" +
                    "Bà nói:\n" +
                    "\n" +
                    "- Xin chào, anh bạn tuấn tú. Tôi tên là Rose. Tôi 87 tuổi. Tôi có thể ôm anh bạn được chứ?\n" +
                    "\n" +
                    "Tôi cười và vui vẻ trả lời:\n" +
                    "\n" +
                    "- Dĩ nhiên là được, thưa bà! - Và bà đã ôm tôi thật chặt.\n" +
                    "\n" +
                    "- Tại sao bà lại vào đại học ở độ tuổi hồn nhiên và trẻ trung như thế này? - Tôi hỏi đùa.\n" +
                    "\n" +
                    "Bà mỉm cười:\n" +
                    "\n" +
                    "- Tôi đến đây để tìm một người đàn ông nổi tiếng, có tâm hồn để yêu và sẽ bên nhau, có một vài đứa con, và sau đó về hưu rồi đi du lịch vòng quanh thế giới.\n" +
                    "\n" +
                    "- Bà nói nghiêm túc chứ? - Tôi hỏi. Tôi tò mò muốn biết điều gì đã thúc đẩy bà muốn thử thách như thế ở độ tuổi của bà.\n" +
                    "\n" +
                    "- Tôi luôn mơ ước được vào một trường đại học và bây giờ tôi đang thực hiện giấc mơ đó! - Bà nói.\n" +
                    "\n" +
                    "Sau khi giờ học kết thúc, chúng tôi đến tòa nhà hội sinh viên và cùng uống với nhau một ly sữa sô-cô-la. Chúng tôi trở thành bạn của nhau ngay. Trong suốt ba tháng tiếp theo, hằng ngày chúng tôi luôn cùng nhau rời khỏi lớp và trao đổi với nhau về mọi việc. Tôi luôn bị cuốn hút bởi “cỗ máy thời gian” này khi nghe bà chia sẻ sự từng trải và kinh nghiệm cuộc đời của bà với tôi.\n" +
                    "\n" +
                    "Trong suốt năm học. Rose trở thành một nhân vật biểu tượng trong trường đại học và dễ dàng kết bạn với tất cả mọi người. Bà thích ăn mặc lịch sự, có tính cách và hạnh phúc với sự chú ý mà các sinh viên khác tập trung vào mình. Bà luôn sống trong niềm say sưa đó.\n" +
                    "\n" +
                    "Vào cuối năm học, chúng tôi mời Rose đến nói chuyện trong một buổi tiệc chiêu đãi và tôi sẽ không bao giờ quên được những gì bà đã truyền cho chúng tôi. Bà được giới thiệu và bước lên bục giảng đường.\n" +
                    "\n" +
                    "Khi bắt đầu bài phát biểu, bà đánh rơi mảnh giấy ghi chú xuống sàn nhà. Hơi ngại ngùng và thoáng bối rối bà cầm micro và nói:\n" +
                    "\n" +
                    "- Xin lỗi quý vị, tôi hơi hồi hộp. Tôi đã bỏ bia và chuyển sang rượu Lent và thứ rượu này đang giết tôi mất! Tôi không bao giờ sắp xếp những gì mình sẽ nói, hãy để cho tôi nói với các bạn một cách giản dị những gì tôi thực sự hiểu.\n" +
                    "\n" +
                    "Khi chúng tôi cười, bà lấy giọng và bắt đầu:\n" +
                    "\n" +
                    "- Chúng ta ngừng vui chơi bởi vì chúng ta đã già; nhưng thật ra chúng ta già bởi vì chúng ta không vui chơi nữa. Chỉ có năm bí quyết để giữ mình trẻ mãi, hạnh phúc và đạt được thành công:\n" +
                    "\n" +
                    "Thứ nhất, các bạn hãy vui cười lên và tìm kiếm sự hài hước trong cuộc sống hàng ngày.\n" +
                    "\n" +
                    "Thứ hai, các bạn hãy xem mỗi ngày là một ngày mới với những điều mới mẻ. Ai sống bằng quá khứ, định kiến của ngày hôm qua sẽ không có cơ hội tin và hiểu con người. Các bạn hãy trải lòng với những người có thể chia sẻ được. Hãy kiên trì, tin vào tâm hồn con người và đừng nhìn vào một lỗi lầm nào đó để phá bỏ tất cả những điều tốt đẹp đã có trước đó và những điều tốt đẹp sẽ đến trong tương lai. Các bạn đừng ngại mạo hiểm để thay đổi cuộc sống.\n" +
                    "\n" +
                    "Thứ ba, các bạn phải có một mơ ước, một khát vọng. Khi các bạn đánh mất những mơ ước đó, các bạn sẽ chết. Đã có quá nhiều người trong chúng ta chết theo kiểu ấy và họ thậm chí cũng không biết đến điều đó!\n" +
                    "\n" +
                    "Thứ tư, có sự khác biệt lớn giữa việc trở nên già hơn và trưởng thành. Nếu bạn 19 tuổi và nằm trên giường suốt một năm trời mà không làm được điều gì hữu ích, bạn sẽ thành 20 tuổi. Nếu tôi 87 tuổi và cứ mãi nằm trên giường suốt một năm và không làm bất cứ điều gì, tôi vẫn sẽ trở thành một bà cụ 88 tuổi. Bất cứ người nào cũng phải lớn lên và già đi. Nhưng điều đó không làm mất đi tài năng và khả năng của bạn. Vấn đề là trưởng thành bằng cách luôn tìm được cơ hội để thay đổi.\n" +
                    "\n" +
                    "Thứ năm, đừng bao giờ tiếc nuối. Người trưởng thành thường không nuối tiếc về những gì mình đã làm mà sẽ nuối tiếc về những gì mình đã không làm. Chỉ những người sợ chết mới hay nuối tiếc.\n" +
                    "\n" +
                    "Bà kết thúc cuộc nói chuyện của mình bằng cách mạnh dạn hát bài “Cánh Hoa Hồng”. Bà đã cùng chúng tôi hát bài đó và lời hát ấy hiện giờ đã trở nên quen thuộc với cuộc sống hàng ngày của chúng tôi.\n" +
                    "\n" +
                    "Và rồi. Rose cũng đã hoàn tất chương trình đại học mà bà đã bắt đầu nhiều năm trước đây. Một tuần sau khi tốt nghiệp. Rose đã ra đi một cách thanh thản trong giấc ngủ. Hơn hai ngàn sinh viên của trường đã đến dự đám tang của bà bằng tất cả lòng kính trọng, mến thương đối với người phụ nữ tuyệt vời đã dùng cuộc đời mình làm tấm gương minh chứng rằng không bao giờ quá trễ để thực hiện tất cả những gì mà bạn có thể làm được trong đời.',6,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mỗi ngày là một món quà','Hôm qua là quá khứ. Ngày mai là tương lai. Chỉ có hôm nay là hiện tại là món quà mà cuộc sống ban tặng cho chúng ta.\n" +
                    "\n" +
                    "- Khuyết danh\n" +
                    "\n" +
                    "Anh rể tôi kéo cái ngăn dưới cùng của chiếc bàn nơi chị tôi vẫn thường ngồi làm việc và lấy ra một cái gói được bọc bằng giấy lụa. Anh xé lớp giấy bên ngoài và cho tôi xem một chiếc quần nhỏ được gói bên trong. Chiếc quần rất dễ thương: được may bằng lụa mềm có viền ren. Trên đó vẫn còn nguyên miếng nhãn ghi giá, một số tiền không nhỏ.\n" +
                    "\n" +
                    "- Jan đã mua nó khi anh chị đến New York lần đầu tiên, cách đây đã 8,9 năm rồi, nhưng cô ấy chưa bao giờ mặc nó. Cô ấy định để dành chờ một dịp đặc biệt. Giờ thì ngoài dịp này ra, chẳng còn có dịp nào khác nữa.\n" +
                    "\n" +
                    "Anh cầm lấy chiếc quần từ tay tôi, đặt nó lên giường cùng những quần áo khác mà chúng tôi định chôn theo chị tôi. Anh mân mê nó một lúc rồi đóng sầm ngăn kéo và quay về phía tôi nói:\n" +
                    "\n" +
                    "- Đừng bao giờ giữ lại bất cứ điều gì để chờ một dịp đặc biệt. Mỗi ngày tồn tại trên cõi đời chính là một dịp đặc biệt rồi đó.\n" +
                    "\n" +
                    "Những lời của anh cứ văng vẳng mãi bên tôi từ lúc đó đến những ngày kế tiếp, khi tôi giúp anh và đứa cháu thu xếp tang lễ cho chị tôi ổn thỏa. Chị tôi đã ra đi thật bất ngờ!\n" +
                    "\n" +
                    "Trên chuyến bay quay về nhà sau đám tang chị, tôi cứ nghĩ về những lời nói ấy, về tất cả những ước mơ chưa trọn vẹn của chị tôi, về những điều chị đã làm mà không nhận ra rằng nó đặc biệt.\n" +
                    "\n" +
                    "Và tôi nghiệm ra: cuộc sống chất chứa bao hương vị ngọt ngào để ta thưởng thức bất cứ khi nào có thể, chứ không phải để ta đối phó. Thế là tôi quyết định thay đổi!\n" +
                    "\n" +
                    "Tôi bắt đầu đọc nhiều hơn và ít bận tâm đến những điều nhỏ nhặt. Tôi thích thú ngắm nhìn cảnh vật khi ngồi trên boong tàu và không rối lên khi thấy đám cỏ dại trong vườn. Tôi dành nhiều thời gian cho gia đình, bạn bè hơn và hạn chế tham dự những cuộc gặp gỡ chẳng mấy bổ ích.\n" +
                    "\n" +
                    "Tôi không để dành bất cứ điều gì nữa: tôi dùng tất cả những món đồ sứ và đồ pha lê xinh đẹp của mình vào mỗi dịp có ý nghĩa - chẳng hạn như giảm được một ký lô, bồn rửa chén hết bị nghẹt hay bông hoa trà đầu tiên hé nở.\n" +
                    "\n" +
                    "Tôi mặc chiếc áo đẹp đi chợ nếu thấy thích. Khi tôi nghĩ mình trông sang trọng, tôi có thể trả nhiều tiền hơn cho một túi rau nhỏ mà không cau mày. Tôi sẽ không để dành lọ nước hoa thơm nhất của mình cho những dịp đặc biệt nào nữa, cho dù các cô bán hàng hay vài người nào đó xì xào bình phẩm.\n" +
                    "\n" +
                    "Tôi đang bỏ dần những cụm từ “một ngày nào đó” hay “nội trong vài ngày” khỏi ngân hàng từ vựng của tôi. Nếu có điều gì đáng xem, đáng nghe hoặc đáng làm, tôi sẽ làm ngay.\n" +
                    "\n" +
                    "Tôi không chắc chị tôi sẽ làm gì nếu biết rằng ngày hôm sau chị không còn trên cõi đời này nữa, cái ngày hôm sau mà tất cả chúng ta mặc nhiên nghĩ nó sẽ đến. Tôi nghĩ chị hẳn đã gọi điện cho những người trong gia đình và vài bạn bè thân. Có lẽ chị đã hẹn gặp một vài người bạn cũ để xin lỗi và xóa đi những chuyện không vui đã qua. Hoặc chị đã đi ra ngoài dùng một bữa cơm Tàu mà tôi đoán mình sẽ chẳng bao giờ được biết!\n" +
                    "\n" +
                    "Những điều nhỏ nhoi chưa làm được sẽ khiến tôi bực bội nếu tôi biết thời gian của mình chỉ có giới hạn. Bực bội bởi tôi đã trì hoãn đi thăm những người bạn tốt mà tôi định sẽ liên lạc vào một ngày nào đó. Bực bội bởi tôi đã không viết những lá thư nào đó mà tôi đã định viết - nội trong vài ngày.\n" +
                    "\n" +
                    "Tôi sẽ bực mình và nuối tiếc vì tôi đã không thường xuyên nói với chồng và con gái tôi rằng tôi yêu họ biết bao. Tôi đang cố gắng rất nhiều để không trì hoãn, giữ lại hay để dành bất cứ điều gì mang thêm tiếng cười và làm cho cuộc sống của chúng tôi thêm phong phú.\n" +
                    "\n" +
                    "Và mỗi buổi sáng, khi thức dậy, tôi luôn tự nhủ: hôm nay là một ngày đặc biệt. Mỗi ngày, mỗi phút, mỗi hơi thở... đều là một món quà của cuộc sống.\n" +
                    "\n" +
                    "Chúng ta không biết chuyện gì có thể sẽ xảy đến với mình trong chuỗi liên khúc lạ thường và bất ngờ của cuộc sống. Tuy nhiên, ta có thể quyết định những gì xảy ra bên trong con người mình, cách nhìn và cách ta đón nhận chúng cũng như ta sẽ làm gĩ với chúng - và đó mới chính là điểm mấu chốt\n" +
                    "\n" +
                    "- Joseph Fort Newton',7,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chắp cánh ước mơ','Ở đâu không có trí tưởng tượng và ước mơ, ở đó con người sẽ lụi tàn và cuộc sống không trọn vẹn.\n" +
                    "\n" +
                    "- Khuyết danh\n" +
                    "\n" +
                    "Có một cậu bé lớn lên trong trại mồ côi luôn mơ ước được bay như chim trên trời. Cậu quả tình không hiểu tại sao những con vật ở thảo cầm viên trông to lớn hơn mình nhiều mà lại bay được. “Tại sao mình không bay được nhỉ?”. Cậu tự hỏi. “Chẳng lẽ mình có gì đó bất thường chăng?”.\n" +
                    "\n" +
                    "Sống gần trại trẻ mồ côi có một chú bé bị liệt đôi chân. Ước muốn duy nhất của chú chỉ là được đi và chạy nhảy như bao bạn bè đồng trang lứa. Trong đầu chú luôn nặng trĩu câu hỏi: “Sao mình không giống như các bạn ấy nhỉ?”.\n" +
                    "\n" +
                    "Một hôm, cậu bé mồ côi đến công viên chơi và tình cờ gặp chú bé tật nguyền đang ngồi nghịch cát. Cậu lân la đến gần làm quen và hỏi xem chú bé kia có khi nào mong muốn được bay lượn như chim không.\n" +
                    "\n" +
                    "- Không! - Chú bé bị liệt trả lời - Nhưng mình luôn muốn biết cảm giác đi và chạy giống như các bạn nó như thế nào.\n" +
                    "\n" +
                    "- Có gì vui đâu! - Cậu bé muốn bay như chim đáp. - À, này, đằng ấy với mình kết bạn với nhau nhé, được không?\n" +
                    "\n" +
                    "- Được chứ, mình cũng thích thế.\n" +
                    "\n" +
                    "Thế rồi hai chú bé ngồi chơi với nhau hàng giờ liền, cùng xây những tòa lâu đài bằng cát và cùng đua nhau phát ra đủ loại âm thanh vui nhộn từ hai chiếc miệng xinh xắn. Chúng nhìn nhau, nét mặt rạng ngời niềm vui. Góc công viên chốc chốc lại rộ lên những tràng cười giòn tan. Cuộc vui dừng lại khi cha của chú bé bị liệt mang xe lăn đến đón con về. Cậu bé luôn ao ước bay được như chim chạy đến bên người cha và nhón chân lên thì thầm điều gì đó vào tai ông.\n" +
                    "\n" +
                    "- Được đấy! - Người cha gật gù.\n" +
                    "\n" +
                    "Xong, cậu bé chạy về phía người bạn mới của mình và bảo:\n" +
                    "\n" +
                    "- Đằng ấy là người bạn duy nhất của mình. Ước gì mình có thể làm gì đó để giúp đằng ấy đi và chạy được như mình. Tuy nhiên, mình nghĩ điều này thì mình có thể làm được.\n" +
                    "\n" +
                    "Dứt lời, cậu xoay người lại và bảo bạn trèo lên lưng mình. Và rồi cậu chạy trên bãi cỏ công viên. Những bước chân ban đầu còn ngắn ngủi, chuệnh choạng, về sau mỗi lúc một nhanh thoăn thoắt hơn lên. Trên lưng, người bạn tật nguyền ôm ghì lấy cổ cậu. Như được tiếp thêm sức mạnh, đôi chân cậu lướt chạy băng băng, cho tới lúc gió tạt mạnh vào mặt hai đứa trẻ.\n" +
                    "\n" +
                    "Người cha đứng lặng nhìn theo cả hai, mắt rưng rưng. Đứa con không đi được của ông đang dang rộng đôi cánh tay, vung vẫy trong gió, và luôn miệng thét to:\n" +
                    "\n" +
                    "- Con đang bay, bố ơi. Con đang bay!',8,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Những con đường mới','Bạn có thể có một khởi đầu tươi sáng bất kỳ lúc nào bạn muốn, bởi cái gọi là thất bại không có nghĩa là gục ngã mà là dừng chân một chỗ.\n" +
                    "\n" +
                    "- Mary Picford\n" +
                    "\n" +
                    "Lúc ấy là năm 1903. Bà Annie Johnson sinh sống tại Arkansascùng hai con trai và đang lâm vào tình cảnh bế tắc. Tiền bạc của bà gần như đã cạn, bản thân bà không có khả năng đặc biệt nào ngoài việc đọc và cộng những con số đơn giản. Thêm vào đó là cuộc hôn nhân không được mãn nguyện và gốc gác da đen vốn bị phân biệt của bà. Tất cả như đang dồn Annie vào ngõ cụt.\n" +
                    "\n" +
                    "Khi bà ngỏ lời với chồng mình, ông William Johnson, rằng bà không hài lòng về cuộc hôn nhân giữa họ, ông thừa nhận nó cũng không như ông mong muốn và từ lâu ông cũng có ý định ra đi học đạo. Ông còn bảo Thượng Đế gọi ông đi truyền giáo tận vùng Enidthuộc bang Oklahoma. Tuy nhiên, ông đã không kể cho bà nghe việc ông có quen một mục sư tại đó, người ông sẽ theo học đạo và có một cô con gái dễ mến chưa lập gia đình. Thế là họ chia tay nhau một cách nhẹ nhàng. Annie giữ lại ngôi nhà chỉ có vỏn vẹn một căn phòng còn ông William mang theo gần hết tiền mặt đến Oklahoma.\n" +
                    "\n" +
                    "Annie là một phụ nữ to cao và đầy nghị lực. Bà quyết định sẽ làm lại từ đầu và gửi bọn nhóc yêu quý của mình cho người khác trông nom. Bà nói:\n" +
                    "\n" +
                    "- Tôi nhìn lại con đường tôi đang đi và quãng đường đã qua, vì không thấy hài lòng nên tôi đã quyết định bước khỏi con đường đó, rẽ sang một hương mới.\n" +
                    "\n" +
                    "Biết mình không có khả năng được thuê làm việc tại nhà máy bông hay xưởng xẻ gỗ trong vùng, bà nghĩ cách tạo kế sinh nhai cho mình dựa vào hai nhà máy này.\n" +
                    "\n" +
                    "Bà lên kế hoạch thật tỉ mỉ và chẳng để ai biết. Một ngày nọ, vào lúc trời sẩm tối, để xem mình đã thật sự sẵn sàng thực hiện kế hoạch chưa, bà đặt những hòn đá vào hai cái xô nặng cỡ 19 lít rồi xách chúng đi gần năm cây số đến nhà máy bông. Sau khi nghỉ ngoi một lát, bà bỏ bớt vài hòn đá rồi đi tiếp 8 cây số nữa trong bóng đêm trên con đường đầy bụi đất đến nhà máy cưa. Trên đường quay trở về tổ ấm nhỏ của mình cùng các con, bà đã bỏ dần những hòn đá còn lại dọc đường.\n" +
                    "\n" +
                    "Đêm đó, bà luộc gà rồi chiên giăm bông. Sau đó bà nhào bột và làm bánh nướng cuốn nhân thịt. Đen gần sáng bà mới đi ngủ.\n" +
                    "\n" +
                    "Sáng hôm sau, bà rời nhà mang theo bánh kẹp thịt, mỡ, một cái chảo sắt và than đá để nhóm lửa. Gần đến giờ ăn trưa, bà xuất hiện ở một khu đất trống sau nhà máy bông. Khi tiếng chuông báo nghỉ trưa vang lên, bà thả rau húng vào chảo mỡ đang sôi. Mùi thơm lan tỏa đến chỗ những công nhân vừa túa ra từ nhà máy, người dính đầy bụi bông trắng trông như những bóng ma.\n" +
                    "\n" +
                    "Hầu hết các công nhân đều đã mang theo phần trưa của mình, nhưng hôm nay họ bị quyến rũ bởi mùi thơm từ những chiếc bánh nhân thịt nóng hổi mà bà Annie vừa vớt ra khỏi chảo. Bà gói chúng bằng giấy báo thấm mỡ và bán với giá 5 xu một cái. Dù bán chậm nhưng những ngày đầu tiên đó Annie rất quyết tâm. Bà phần chia đồng đều việc bán hàng ở cả hai nhà máy.\n" +
                    "\n" +
                    "Thế là, nếu ngày thứ hai bà bán bánh nóng giòn ở nhà máy bông và bán những chiếc bánh đã nguội còn dư ở nhà máy cưa với giá ba xu, thì thứ ba bà sẽ đến nhà máy cưa trước để chào bánh mới ra lò khi những người thợ xẻ người đầy mạt cưa xuất hiện ở cổng nhà máy.\n" +
                    "\n" +
                    "Trong những năm kế đó, vào những ngày xuân êm dịu, những trưa hè nóng bỏng, hay những ngày lạnh lẽo mưa dầm tuyết rơi, Annie không bao giờ làm thất vọng khách hàng của mình, những người tin chắc sẽ gặp hình ảnh một người phụ nữ cao lớn, da ngăm đen khom người bên chảo dầu, cẩn thận trở từng miếng bánh kẹp thịt. Khi cảm thấy chắc chắn những người công nhân kia đã là những khách hàng thân thiết, bà dựng một cái sạp giữa hai nhà máy cho họ đến dùng bữa.\n" +
                    "\n" +
                    "Thật sự, bà đã bước ra khỏi con đường mà dường như đã được chọn sẵn cho bà để rồi tìm cho mình một lối đi hoàn toàn mới. Nhiều năm sau, gian hàng ấy đã trở thành cửa hàng nơi khách hàng có thể mua bất cứ thứ gì, từ pho mát, thức ăn, xirô, bánh bích quy, kẹo, đồ chua, đồ hộp, trái cây tươi, nước ngọt, đến than đá, dầu và cả đế da cho những đôi giày đã mòn.\n" +
                    "\n" +
                    "Mỗi người chúng ta đều có quyền và trách nhiệm xem xét những con đường phía trước, cũng như những con đường ta đã đi qua. Nếu con đường tương lai không sáng sủa hay không hứa hẹn với ta điều gì và ta không thể quay đầu lại, chúng ta cần quyết tâm, và chỉ mang theo hành trang cần thiết, bước khỏi con đường đó rồi rẽ sang hương khác. Nếu sự lựa chọn mới cũng không thể chấp nhận được, đừng bối rối, chúng ta hãy sẵn sàng thay đổi nó.',9,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tâm hồn và tình yêu của thiên nga','Cái giây phút mà bạn có được trong tim mình một cảm giác kỳ lạ mang tên Tình Yêu và cảm nhận được chiều sâu, sự lung linh, ngất ngây của nó thì chính lúc ấy bạn sẽ nhận ra rằng thế giới xung quanh bạn đã thay đổi.\n" +
                    "\n" +
                    "- J. Krishnamurti\n" +
                    "\n" +
                    "Năm thứ hai đại học của tôi sắp sửa kết thúc. Vào một đêm nóng bức trong tuần cuối cùng của tháng năm, tôi nhận được điện thoại của mẹ ở ký túc xá cho biết tôi sẽ về nghỉ hè với ông bà để phụ giúp công việc đồng áng. Ý kiến này khiến mọi người trong nhà đều hài lòng. Riêng tôi không hoàn toàn bị thuyết phục lắm nhưng tự an ủi rằng dù gì cũng chỉ có một kỳ nghỉ mà thôi.\n" +
                    "\n" +
                    "Sau khi thi xong môn cuối, tôi thu dọn đồ lên xe, chào tạm biệt bạn bè và hẹn sẽ gặp lại vào mùa thu. Các bạn tôi cũng vậy vì hầu hết bọn họ cũng sẽ về nhà.\n" +
                    "\n" +
                    "Từ trường tôi về đến nông trại mất hết ba giờ lái xe. Ông bà tôi đều đã qua tuổi bảy mươi, và tôi biết họ rất cần người phụ giúp công việc của nông trại, ông không thể dọn cỏ khô một mình cũng như sửa chữa chuồng trại cùng hàng đống việc khác.\n" +
                    "\n" +
                    "Chiều hôm ấy tôi đến nơi muộn. Bà đã nấu nhiều đồ ăn đến nỗi cả ba chúng tôi không thể nào ăn cho hết. Bà hết sức yêu thương và quan tâm tới đứa cháu của mình. Tôi đã nghĩ rằng sự niềm nở này sẽ nhanh chóng phai nhạt một khi tôi ở lâu cùng với bà. Nhưng không phải vậy. Ông muốn biết tất cả mọi điều về tôi. Đến giờ ngủ, tôi nghĩ rằng mọi thứ rồi sẽ ổn. Dầu gì, tôi cũng chỉ phải ở đây một mùa hè thôi.\n" +
                    "\n" +
                    "Sáng hôm sau, tự ông chuẩn bị bữa sáng cho hai người. Ông bảo rằng bà bị mệt vì đã vất vả cả ngày hôm qua nên sẽ nằm nghỉ lâu một chút. Tôi tự nhủ sẽ không nhờ bà làm bất cứ điều gì cho mình trong thời gian lưu lại. Tôi đến đây để giúp đỡ chứ không phải làm gánh nặng cho ông bà.\n" +
                    "\n" +
                    "Buổi sáng đó, ông khiến tôi rất ngạc nhiên. Khi chúng tôi rời khỏi nhà, ông dường như sinh động và linh hoạt hẳn lên. Nông trại này là lãnh địa của ông. Mặc dù đã lớn tuổi, ông vẫn giữ được dáng vẻ tự tin khi đi khắp nơi trong khu vực này. Ông không còn có dáng vẻ gì của con người đã thiếp đi trên ghế tối qua trước lúc bản tin sáu giờ chấm dứt. Khi chúng tôi băng qua cánh cổng để đến xem xét đàn gia súc, ông dường như biết rất rõ từng con bò. Mà có tới gần hai trăm con trong đàn chứ ít gì!\n" +
                    "\n" +
                    "Chúng tôi không thật sự làm nhiều việc trong ngày đầu, nhưng tôi lấy làm cảm phục về tất cả những gì mà ông đã thực hiện trong suốt những năm tôi chưa sinh ra. Ông không được ăn học đầy đủ nhưng đã nuôi dạy bốn người con khôn lớn nên người nhờ vào nông trại này. Tôi thật sự ấn tượng sâu sắc về điều đó.\n" +
                    "\n" +
                    "Nhiều tuần lễ trôi qua. Đến tháng sáu, chúng tôi đã gom xong cỏ khô, cột lại thành bó và cất vào nhà kho. Tôi cũng dần quen với chuyện cùng ông làm việc mỗi ngày. Những gì cần làm ông đều dự tính sẵn trong đầu và mỗi ngày chúng tôi chỉ việc thực hiện từng phần. Buổi chiều tối ở nhà, tôi thường đọc sách hay nói chuyện với bà. Bà không bao giờ chán những câu chuyện ở trường hay bất cứ chuyện gì có liên quan đến tôi. Bà còn kể cho tôi nghe về thời bà mới gặp ông, về tình yêu của ông dành cho bà, về ánh mắt thuở ban đầu mà bà còn nhớ mãi về ông...\n" +
                    "\n" +
                    "Sáng chủ nhật tuần cuối cùng của tháng sáu, ông rủ tôi đi câu cá vì chúng tôi đã hoàn tất mọi việc. Hồ nước nằm trong một cánh đồng trũng gần khu rừng. Những năm trước ông đã thả cá xuống hồ. Hôm đó chúng tôi lái xe đến hồ, tiện thể coi qua đàn gia súc. Chúng tôi không thể ngờ đến những gì mình trông thấy sáng hôm đó: Một con trong cặp thiên nga mà ông tặng bà vào ngày lễ Kim Khánh đã chết. Con còn lại không chịu ăn mà cứ ngước nhìn về một hương xa xăm.\n" +
                    "\n" +
                    "- Sao mình không mua một con khác thế vào hở ông? - Tôi đề nghị với hi vọng có thể cứu vãn được tình thế.\n" +
                    "\n" +
                    "Suy nghĩ một lát. Cuối cùng ông nói:\n" +
                    "\n" +
                    "- Không... không dễ dàng vậy đâu con ạ! Con biết không, loài thiên nga cả đời chỉ có một bạn tình.\n" +
                    "\n" +
                    "Ông đưa tay chỉ trong khi tay kia giữ cần câu - loài khác thì được, còn thiên nga thì không. Có thể mang đến cho nó một con khác nhưng chẳng thể mang lại một tâm hồn như nó vốn đã từng mong chờ, tìm được và thấu hiểu. Chúng ta chẳng thể làm được gì hơn cho con thiên nga còn lại. Nó phải tự xoay xở lấy mà thôi.\n" +
                    "\n" +
                    "Suốt buổi sáng chúng tôi đã bắt đủ số cá cho bữa trưa. Trên đường về, ông dặn tôi đừng kể cho bà nghe về chuyện con thiên nga. Bà không còn đi về phía hồ nhiều nữa. Vì thế, cho bà biết việc đó cũng chẳng ích gì.\n" +
                    "\n" +
                    "Vài ngày sau, ông và tôi có đi ngang hồ trong khi làm công việc kiểm tra đàn gia súc mỗi sáng. Chúng tôi trông thấy con thiên nga còn lại đang nằm đúng nơi bạn nó được tìm thấy trước đó. Và... Nó cũng đã chết...\n" +
                    "\n" +
                    "Ông và tôi bắt đầu tháng bảy bằng công việc dựng một hàng rào mới. Đen ngày 12 tháng 7, bà tôi qua đời. Sáng hôm ấy tôi ngủ dậy muộn và ông cũng chẳng gõ cửa phòng gọi. Đen gần tám giờ sáng, tôi mới vội vã thay đồ và xuống bếp. Bác sĩ Morgan đang ngồi tại bàn trong nhà bếp. Ông ấy đã là hàng xóm của ông bà tôi từ lâu kể từ khi về hưu. Trước đây, ông có tới nhà tôi vài lần mỗi khi cần kíp. Ngay lập tức, tôi nhận ra có điều gì bất ổn. Sáng nay, bên cạnh chân bác sĩ là chiếc cặp đen cũ ký. Và, rõ ràng ông tôi đang run rẩy.\n" +
                    "\n" +
                    "Bà tôi đã đột ngột qua đời bởi chứng đột quy. Cha mẹ tôi đến ngay trong buổi chiều ấy. Người thân và bạn bè của ông bà cũng nhanh chóng tề tựu tại căn nhà cũ này.\n" +
                    "\n" +
                    "Đám tang được tổ chức ngay ngày hôm sau vì ông nhất quyết muốn nó diễn ra càng sớm càng tốt. Vào ngày thứ hai sau đám tang, ông nói trong bữa sáng:\n" +
                    "\n" +
                    "- Đây là một nông trại bận rộn. Chúng tôi còn rất nhiều việc phải làm. Những người còn lại hãy trở về với công việc của mình.\n" +
                    "\n" +
                    "Hầu hết mọi người trong gia đình đều đã đi khỏi, nhưng đó là cách ông bảo mọi người là đã đến lúc phải về nhà. Cha mẹ tôi là người cuối cùng ra về sau bữa trưa.\n" +
                    "\n" +
                    "Ông tôi không phải là người có thể dễ dàng bộc lộ nỗi đau của mình cho ai khác. Cho nên, tất cả chúng tôi đều lo lắng cho ông. Mọi người đã bàn tính khuyên ông từ bỏ việc đồng áng. Cha mẹ tôi cũng nghĩ rằng ông đã già quá rồi nên không thể nào sống một mình ở đấy. Tuy nhiên, ông không hề bận tâm đến chuyện đó. Tôi thật sự tự hào về cách mà ông tự khẳng định mình.\n" +
                    "\n" +
                    "Những ngày hè còn lại dần trôi qua. Chúng tôi vẫn bận rộn với công việc. Tôi lờ mờ nhận thấy ông có điều gì đó khang khác nhưng không chắc lắm. Tôi bắt đầu nghi ngại liệu ông có thể sống tốt hơn được với một ai đó không, nhưng tôi biết ông không thể nào rời bỏ nông trại.\n" +
                    "\n" +
                    "Tháng chín đang đến gần, nhưng tôi lại không muốn ra đi. Tôi cũng tính đến việc bỏ học kỳ mùa thu này để ở với ông thêm vài tháng cho ông bớt cô đơn. Khi tôi đề cập đến việc này, ông lập tức phản đối, bảo rằng chỗ của tôi là trường đại học chứ không phải chốn này.\n" +
                    "\n" +
                    "Cuối cùng đã đến lúc tôi phải thu dọn đồ lên xe và rời khỏi đây. Tôi bắt tay và ôm ông chào tạm biệt. Khi lái xe đi, qua kính chiếu hậu tôi còn nhìn thấy ông vẫy tay chào rồi quay về hương đồng cỏ để bắt đầu công việc kiểm tra đàn gia súc mỗi sáng. Đó là hình ảnh về ông mà tôi hằng lưu giữ trong tâm trí.\n" +
                    "\n" +
                    "Mẹ gọi điện đến trường cho tôi vào một buổi sáng dông bão để báo tin ông mất. Một người hàng xóm ghé ngang nhà uống cà-phê sáng hôm đó và tìm thấy ông trong bếp. Ông mất vì chứng đột quy giống như bà. Trong khoảnh khắc đó, tôi đã hiểu ra được những điều mà ông đã cố gắng giải thích cho tôi về con thiên nga vào buổi sáng chúng tôi đi câu bên hồ.',10,1)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Người chạy cuối cùng','Phần thưởng cao quý nhất cho công sức lao động của một người không phải là những gì người ấy nhận được, mà chính là qua đó anh ta đã tự cảm nhận được mình đã trưởng thành như thế nào.\n" +
                    "\n" +
                    "- John Ruskin\n" +
                    "\n" +
                    "Cuộc đua marathon hàng năm ở thành phố tôi thường diễn ra vào mùa hè. Nhiệm vụ của tôi là ngồi trong xe cứu thương, theo sau các vận động viên, phòng khi có ai đó cần được săn sóc y tế. Người tài xế và tôi sẵn sàng trong xe, phía sau hàng trăm con người, chờ tiếng súng lệnh vang lên.\n" +
                    "\n" +
                    "- Chúng ta sẽ theo sau người chạy cuối cùng nên anh hãy lái xe chầm chậm thôi - Tôi nói với người tài xế, Doug, khi xe bắt đầu lăn bánh về phía trước.\n" +
                    "\n" +
                    "- Hy vọng người cuối cùng sẽ chạy nhanh - Anh pha trò.\n" +
                    "\n" +
                    "Khi đoàn người tăng tốc, nhóm chạy đầu tiên dần vượt lên trước. Chính lúc đó hình ảnh một người phụ nữ mặc quần soóc màu xanh da trời và áo thun rộng thùng thình đập vào mắt tôi.\n" +
                    "\n" +
                    "- Doug, nhìn kìa!\n" +
                    "\n" +
                    "Chúng tôi biết mình đã nhận diện được “người cuối cùng”. Bàn chân chị ấy cứ chụm vào mà đầu gối lại cứ đưa ra. Đôi chân tật nguyền của chị tưởng chừng như không thể nào bước đi được, chứ đừng nói là chạy.\n" +
                    "\n" +
                    "Doug và tôi lặng lẽ nhìn chị từ từ tiến lên - chẳng ai nói lời nào. Chúng tôi cứ nhích lên từng quãng một rồi dừng lại để chờ chị.\n" +
                    "\n" +
                    "Nhìn chị chật vật đặt bàn chân này lên trước bàn chân kia mà tôi tự dưng thở giùm cho chị, rồi reo hò cổ động cho chị tiến lên. Tôi nửa muốn chị ngừng lại nửa cầu mong chị tiếp tục.\n" +
                    "\n" +
                    "Cuối cùng, chị là người duy nhất còn trong tầm nhìn. Tôi ngồi ra cả mép ghế, theo dõi - với vẻ sờ sợ, phấn khích chen lẫn tôn kính - người phụ nữ vẫn kiên trì tiến tới, quả quyết vượt qua những dặm cuối cùng.\n" +
                    "\n" +
                    "Vạch đích hiện ra, tiếng người la ó ầm ĩ hai bên đường. Kìa, một người đàn ông đứng thẳng và tự hào đang chờ. Anh ấy cầm một đầu sợi ruy-băng giấy kếp, đầu kia buộc vào cây cột. Chị chầm chậm tiến tới, băng qua, giật đứt hai đầu sợi dây cho nó bay phấp phới sau lưng tựa như đôi cánh.\n" +
                    "\n" +
                    "Tôi không biết tên người phụ nữ đó, nhưng kể từ ngày hôm ấy chị đã trở thành một phần ký ức cuộc đời tôi - và tôi phụ thuộc nhiều vào phần đời này. Với chị, điều quan trọng không phải là đánh bại những người chạy khác hay giành lấy phần thưởng; mà là cố hoàn thành đoạn đường đua cho dù phải nỗ lực tới đâu. Mỗi lúc gặp phải tình huống quá khó khăn, quá tốn thời gian hoặc tưởng như “không thể làm được”, tôi lại nghĩ đến “người chạy cuối cùng”. Liền sau đó thì mọi việc trở nên thật dễ dàng đối với tôi.',11,1)");

            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Lắng nghe những điều giản dị','Hãy bỏ tất cả những ưu phiền của hạn vào một chiếc túi lủng.\n" +
                    "\n" +
                    "- Old Postcard\n" +
                    "\n" +
                    "Cách đây không lâu, tôi đã rơi vào một giai đoạn rất tồi tệ trong cuộc sống mà có lẽ nhiều người trong chúng ta cũng đã từng trải qua. Khi đó, với tôi mọi thứ đều trở nên chán chường và tẻ nhạt, sức khoẻ giảm sút - ngọn lửa nhiệt tình và hăng hái đã tắt ngấm. Điều đó tác động thật đáng sợ đến cuộc sống và công việc của tôi. Mỗi sáng, tôi nghiến chặt răng lại tự nhủ: Hôm nay, cuộc sống tiếp tục trôi theo lối mòn của nó đấy. Mình phải vượt qua nó. Nhất định mình phải làm như thế!\n" +
                    "\n" +
                    "Nhưng rồi chuỗi ngày nhàm chán vẫn kéo dài, và tình trạng tê liệt, không lối thoát ấy dường như ngày một tệ hơn. Đã đến lúc tôi biết mình cần phải nhờ giúp đỡ.\n" +
                    "\n" +
                    "Tôi đã đến gặp một bác sĩ. Ông ta lớn tuổi hơn tôi và trông có vẻ cộc cằn. Tuy nhiên, tôi không ngờ đằng sau vẻ bề ngoài không mấy thiện cảm kia là một con người rất uyên thâm và từng trải. Tôi kể với vị bác sĩ một cách đau khổ, rằng dường như tôi bị bế tắc.\n" +
                    "\n" +
                    "- Liệu bác sĩ có thể giúp tôi không?\n" +
                    "\n" +
                    "- Tôi không biết.\n" +
                    "\n" +
                    "Vị bác sĩ chậm rãi trả lời, rồi chống tay nhìn chằm chằm vào tôi một lúc lâu. Đột nhiên ông hỏi:\n" +
                    "\n" +
                    "- Hồi còn bé, anh thích nơi nào nhất?\n" +
                    "\n" +
                    "- Hồi còn bé à? - Tôi hỏi lại. - Sao bác sĩ lại hỏi như vậy? Tôi nghĩ là ở bãi biển. Gia đình tôi có một ngôi nhà nghỉ bên bờ biển. Cả nhà đều thích nó.\n" +
                    "\n" +
                    "Vị bác sĩ nhìn ra ngoài cửa sổ, đưa mắt theo mấy chiếc lá thu rơi rụng rồi hỏi tiếp.\n" +
                    "\n" +
                    "- Thế anh có thể làm theo lời tôi nói trong cả một ngày không?\n" +
                    "\n" +
                    "- Tôi nghĩ là được. Tôi sốt sắng trả lời.\n" +
                    "\n" +
                    "- Được rồi. Tôi muốn anh làm như vầy...\n" +
                    "\n" +
                    "Theo lời vị bác sĩ, hôm sau tôi phải lái xe đến bãi biển một mình và không được đến trễ quá 9 giờ sáng. Tôi có thể ăn trưa, nhưng không được đọc, viết, nghe đài hay nói chuyện với bất kỳ ai. Thêm nữa, ông ta nói:\n" +
                    "\n" +
                    "- Tôi sẽ đưa cho anh một toa thuốc, cứ cách 3 giờ thì dùng một lần.\n" +
                    "\n" +
                    "Rồi ông lấy một tờ giấy trắng xé thành bốn mảnh, viết vài chữ lên mỗi mảnh, gấp lại và đánh số rồi trao chúng cho tôi.\n" +
                    "\n" +
                    "- Anh hãy dùng những liều thuốc này vào lúc 9 giờ sáng, 12 giờ trưa, 3 giờ chiều và 6 giờ tối theo số thứ tự.\n" +
                    "\n" +
                    "- Bác sĩ nói nghiêm túc đấy chứ ạ? - Tôi ngỡ ngàng hỏi.\n" +
                    "\n" +
                    "Vị bác sĩ bật cười:\n" +
                    "\n" +
                    "- Anh sẽ không nghĩ là tôi đang đùa khi tôi lấy tiền khám bệnh của anh.\n" +
                    "\n" +
                    "Sáng hôm sau, với niềm tin nhỏ nhoi về phương thuốc của vị bác sĩ, tôi lái xe đến bãi biển một mình đúng như lời ông dặn. Một ngọn gió đông bắc thổi qua, mặt biển trông xám xịt và những cơn sóng vỗ ầm ào như giận dữ. Tôi ngồi trong xe, phía trước là cả một ngày dài đằng đẵng và trống rỗng. Rồi tôi mở mảnh giấy thứ nhất ra xem. Trên đó là hàng chữ: “Hãy chăm chú lắng nghe”.\n" +
                    "\n" +
                    "Không thể hiểu nổi! Chắc vị bác sĩ đó điên mất rồi! Ông ta đã cấm tôi nghe nhạc, đọc báo và tiếp xúc với những người khác rồi, còn cái gì khác nữa để mà nghe cơ chứ?\n" +
                    "\n" +
                    "Tuy nhiên, tôi vẫn quyết định làm theo lời ông. Tôi ngẩng đầu lắng nghe. Chẳng có âm thanh nào ngoài tiếng sóng vỗ ầm ầm đều đặn, tiếng kêu léc chéc của con mòng biển, và tiếng ầm ì của vài chiếc máy bay trên bầu trời. Những âm thanh thật quen thuộc!\n" +
                    "\n" +
                    "Tôi ra khỏi xe. Một cơn gió mạnh làm chiếc cửa đóng sập vào. Tôi tự hỏi: Phải chăng vị bác sĩ đề nghị tôi phải chú ý lắng nghe những âm thanh đó?\n" +
                    "\n" +
                    "Tôi leo lên một đụn cát và nhìn ra phía xa xa của bãi biển hoang vắng. Ngồi ở đây tôi nghe thấy tiếng sóng biển gầm thét lớn hơn, át cả những âm thanh khác. Và đột nhiên tôi nghĩ, hẳn phải có những âm thanh khác nữa bên dưới những tiếng sóng đó - tiếng soạt nhẹ của cát trồi giạt, tiếng thì thầm của gió trong đám cây dại mọc ở cồn cát - nếu như người nghe thật chăm chú.\n" +
                    "\n" +
                    "Như bị thôi thúc, tôi nhảy xuống biển và ngụp lặn trong làn nước. Bỗng thấy buồn cười về hành động của mình, tôi chúi đầu vào đám rong biển. Ngay lúc ấy, tôi khám phá ra rằng: nếu chú tâm lắng nghe, ta còn có thể nghe được những khoảnh khắc khi mà tất cả mọi thứ đều ngừng lại như chờ đợi. Trong khoảnh khắc yên lặng đó, mọi suy nghĩ trong đầu ta đều ngưng đọng và tâm trí ta được nghỉ ngơi.\n" +
                    "\n" +
                    "Tôi trở lại xe và nằm thượt sau tay lái, tiếp tục chăm chú lắng nghe. Khi tôi nghe lại lần nữa tiếng gầm vang lên từ sâu thẳm trong lòng đại dương, tôi thấy mình đang nghĩ về sự thịnh nộ của những cơn giông tố nổi lên ngay chính trong lòng những cơn sóng. Sau đó tôi nhận ra mình đang nghĩ đến những thứ còn to lớn hơn cả chính bản thân tôi - và lòng tôi thấy khuây khỏa với những ý nghĩ ấy.\n" +
                    "\n" +
                    "Cứ như thế, buổi sáng trôi qua rất chậm chạp. Thói quen ném mình vào một vấn đề rắc rối đã in sâu vào tôi đến nỗi tôi cảm thấy mình bị chìm nghỉm nếu không có nó.\n" +
                    "\n" +
                    "Đến trưa, trời quang đãng không một gợn mây, mặt biển như đang tỏa sáng lấp lánh. Tôi mở mảnh giấy thứ hai. Một lần nữa, tôi lại thấy nửa vui nửa cáu. Liều thuốc thứ hai là: “Cố gắng tìm về ký ức...”\n" +
                    "\n" +
                    "Ký ức gì nhỉ? Hiển nhiên là những ký ức đẹp trong quá khứ rồi. Nhưng tại sao lại phải như thế chứ, khi tất cả những lo lắng của tôi đều liên quan đến hiện tại hay tương lai?\n" +
                    "\n" +
                    "Tôi rời xe và bắt đầu đi dọc theo những đụn cát. Vị bác sĩ đã giúp tôi trở lại bãi biển này, nơi ghi dấu biết bao ký niệm hạnh phúc thời thơ bé của tôi. Đó có lẽ là những gì mà ông đề nghị tôi tìm lại - những niềm vui và hạnh phúc chất ngất mà tôi đã bỏ quên lại sau lưng.\n" +
                    "\n" +
                    "Tôi quyết định sẽ làm sống lại những giây phút đã nhạt nhòa ấy. Tôi sẽ tô màu và làm sắc lại bức tranh hạnh phúc của quá khứ. Tôi sẽ chọn những gì cụ thể và vẽ lại thật chi tiết. Tôi sẽ hình dung những con người trong bức tranh ấy ăn mặc và vui đùa như thế nào. Tôi sẽ tập trung lắng nghe chính xác âm thanh giọng nói cũng như tiếng cười của họ.\n" +
                    "\n" +
                    "Thủy triều đang xuống dần, nhưng tiếng sóng vẫn vỗ ầm ầm. Tôi chọn quay lại thời điểm của chuyến đi câu cá cuối cùng của tôi với đứa em trai 20 năm về trước. Nó đã tử trận trong Chiến tranh Thế giới thứ hai nhưng tôi nhận ra rằng nếu tôi nhắm mắt và thật sự cố gắng, tôi có thể nhìn thấy hình ảnh em tôi sống động đến ngạc nhiên, thậm chí tôi còn nhìn thấy cả nét hóm hỉnh và sự hăm hở trong mắt nó.\n" +
                    "\n" +
                    "Thật ra tôi đã thấy toàn cảnh bức tranh ngày hôm đó: mặt biển lấp lánh, ánh bình minh ló dạng trên bầu trời phía đông, những đợt sóng cuồn cuộn đánh vào bờ một cách oai vệ và chậm chạp. Tôi cảm thấy những dòng nước xoáy ngược ấm áp vây quanh đầu gối, chiếc cần câu của em tôi đột nhiên nảy lên khi một con cá bị dính mồi, và tôi nghe tiếng la mừng rỡ của nó. Tôi đã họa lại bức tranh ấy từng mảng một, rất rõ ràng và không một thay đổi sau bao năm tháng. Rồi những hình ảnh ấy trôi qua...\n" +
                    "\n" +
                    "Tôi đứng dậy một cách chậm chạp cố gắng tìm về quá khứ của mình. Những người hạnh phúc luôn là những người tự tin và quả quyết. Nếu bạn thong thả quay lại tìm và chạm tay tới những điều hạnh phúc, lẽ nào không tìm thấy một chút sức mạnh?\n" +
                    "\n" +
                    "Giai đoạn thứ hai trong ngày đã trôi qua nhanh chóng. Khi mặt trời bắt đầu chếch bóng, tâm trí tôi hăm hở đi trên cuộc hành trình về quá khứ, sống lại những khoảnh khắc, phát hiện ra những con người mà tôi đã hoàn toàn lãng quên. Những năm qua, tôi đã nhớ thêm rất nhiều sự kiện nhưng đã vô tình để những hạnh phúc trong quá khứ bị cuốn theo dòng thời gian. Một cảm giác ấm áp chợt dâng lên trong lòng tôi, lúc đó tôi hiểu rằng chẳng có lòng tốt nào là lãng phí hay có thể mất đi ý nghĩa của nó cả.\n" +
                    "\n" +
                    "Đến ba giờ chiều, nước đã xuống và âm thanh của những con sóng giờ chỉ là một lời thì thầm theo nhịp. Biển như một gã khổng lồ đang thở. Những đụn cát giờ như đã là tổ ấm của tôi. Tôi cảm thấy thư giãn, hài lòng và hơi tự mãn. Những liều thuốc của vị bác sĩ thật dễ uống.\n" +
                    "\n" +
                    "Nhưng tôi chưa sẵn sàng uống liều thuốc thứ ba. Lời yêu cầu lần này không phải nhẹ nhàng. Chúng giống như một mệnh lệnh hơn: “Xem lại động cơ của mình”.\n" +
                    "\n" +
                    "Phản ứng đầu tiên của tôi khi đọc những lời ấy là phải tự thanh minh cho mình. Những động cơ của tôi chẳng có gì là xấu, tôi tự nhủ. Tôi muốn thành công - ai mà chẳng thế? Tôi muốn được công nhận, nhưng những người khác cũng như tôi thôi. Tôi muốn được yêu thương, được an toàn hơn - và tại sao lại không như thế chứ?\n" +
                    "\n" +
                    "Có lẽ, một tiếng nói nhỏ vang lên đâu đó trong đầu tôi, những động cơ đó không hoàn toàn trong sáng. Có lẽ đó chính là lý do tại sao tôi bế tắc.\n" +
                    "\n" +
                    "Tôi cúi xuống, với lấy một nắm cát rồi để nó rơi qua những kẽ tay mình. Trong quá khứ, những điều tôi làm tốt luôn xảy đến một cách tự nhiên, không hề dự tính trước. Gần đây, thay vào đó là sự toan tính, được chuẩn bị ký lưỡng nhưng mọi việc lại không suôn sẽ. Tại sao? Bởi tôi đã nhìn xa hơn bản thân công việc, tôi chỉ nghĩ đến những phần thưởng mà tôi hy vọng nó sẽ mang lại. Và công việc chỉ đứng một chỗ, nó đã trở thành một phương tiện chỉ để kiếm tiền. Cảm giác cho đi điều gì đó, giúp đỡngười khác, cống hiến... đã bị mất hút trong sự hối hả nắm lấy lợi ích cho bản thân mình.\n" +
                    "\n" +
                    "Thoáng chốc, tôi nhận ra một điều chắc chắn rằng, nếu động cơ của một người thiếu đi sự trong sáng thì tất cả những gì còn lại đều không có kết quả. Dù bạn là một người đưa thư, thợ hớt tóc, một người bán bảo hiểm, một ông bố luôn ở nhà hay một bà nội trợ thì cũng chẳng có gì khác nhau. Chỉ khi bạn cảm thấy mình đang phục vụ cho người khác, bạn mới thực hiện tốt công việc được. Còn nếu chỉ quan tâm đến những gì mình sẽ đạt được, hiệu quả công việc của bạn sẽ giảm đi. Đó là quy luật tự nhiên của cuộc sống.\n" +
                    "\n" +
                    "Tôi ngồi một lúc lâu. Phía xa kia, tiếng sóng vỗ rì rào đã chuyển thành tiếng gầm do thủy triều lên. Sau lưng tôi, những tia nắng cuối cùng của một ngày đang gần như khuất dạng dưới đường chân trời. Một ngày ở biển của tôi đã gần kết thúc, tôi cảm thấy khâm phục đến ghen tỵ vị bác sĩ và những liều thuốc mà ông đã cho tôi, chúng quá lạ lùng và lại giản dị đến bất ngờ. Giờ đây tôi đã thấy đó là những liều thuốc giá trị cho bất cứ ai đang phải đối mặt với bất kỳ khó khăn nào.\n" +
                    "\n" +
                    "Chăm chú lắng nghe: để bình tĩnh và làm dịu đi một tâm trí điên rồ, chuyển sự tập trung từ những điều bên trong ra bên ngoài.\n" +
                    "\n" +
                    "Cố gắng tìm về quá khứ: bởi trí óc con người chỉ có thể lưu một ý nghĩ trong một lúc, để xóa đi sự lo lắng hiện tại khi bạn hương về niềm hạnh phúc trong quá khứ.\n" +
                    "\n" +
                    "Xem xét lại động cơ của mình: đây là mấu chốt của việc điều trị. Đánh giá lại, đặt những động cơ của một người ngang bằng với khả năng và lương tâm của người đó. Và bạn cần phải thực tâm khi làm điều này.\n" +
                    "\n" +
                    "Mặt trời phía tây đã ngả sang màu đỏ chói khi tôi lấy ra mảnh giấy cuối cùng. Đọc xong hàng chữ viết trên ấy, tôi đi chầm chậm ra biển. Khi chỉ còn vài mét nữa là đến mép nước, tôi dừng lại và đọc hàng chữ lần nữa: “Viết những ưu phiền lên cát”.\n" +
                    "\n" +
                    "Tôi thả mảnh giấy bay đi, cúi xuống nhặt một mảnh vỏ sò vỡ. Dưới vòm trời cao vút, tôi đã viết thật nhiều trên mặt cát, hết nỗi ưu phiền này đến ưu phiền khác... Sau đó tôi quay bước đi và không nhìn lại. Tôi đã viết những ưu phiền của mình lên cát. Và ngoài kia, những con sóng đang tạt vào...',1,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tình yêu tạo nên lẽ sống','Tình yêu là phương thuốc nhiệm mầu cho tất cả chúng ta - cả những người trao tặng lẫn những người đón nhận nó.\n" +
                    "\n" +
                    "- Karl Menninger\n" +
                    "\n" +
                    "Tôi chỉ mới 12 tuổi, nhưng tôi đã biết buồn và rất sợ cái chết mỗi khi nghĩ đến ông ngoại, người mang trong mình căn bệnh gọi là “khí thủng” do thói quen hút thuốc từ hồi ông còn học trung học. Đó là một bệnh khủng khiếp, nó có thể phá hủy toàn bộ hệ thống hô hấp của người bệnh.\n" +
                    "\n" +
                    "Từ khi bà tôi qua đời, ông rất buồn và thậm chí còn nổi giận với cả cuộc đời. Ông trở nên bẳn tính và đôi khi còn nói những lời khó nghe làm tổn thương đến những người tử tế. Tuy vậy, khi ở bên tôi, dường như tất cả sự dịu dàng trong ông đều được bộc lộ.\n" +
                    "\n" +
                    "Gần đây, ông bị ốm nặng, phải phẫu thuật cổ họng và dùng máy hô hấp mới thở được. Các bác sĩ cho biết cuộc sống của ông chỉ còn có thể đếm từng ngày, nhưng kỳ diệu thay ông lại hồi phục, ông không cần dùng máy hô hấp để thở nữa nhưng vẫn chưa thể nói được. Những câu nói của ông chỉ còn là những âm thanh khò khè yếu ớt.\n" +
                    "\n" +
                    "Lúc ông đang nằm viện, tôi và mẹ đã về quê thăm ông. Chúng tôi sợ sẽ không còn dịp nào để gặp ông nữa.\n" +
                    "\n" +
                    "Khi hai mẹ con bước vào phòng ông, tôi thật sự bị sốc vì bệnh tình của ông. Trông ông rất mệt, chẳng thể làm được bất kỳ điều gì dù chỉ là thốt ra vài tiếng càu nhàu. Dù vậy, chẳng biết bằng cách nào đó, ông nhìn tôi và lẩm bẩm được hai tiếng: “ông... cháu. “\n" +
                    "\n" +
                    "- Ông nói gì ạ?- Tôi thì thầm.\n" +
                    "\n" +
                    "Ông không còn sức để trả lời tôi nữa. Tất cả sức lực còn lại trong người, ông đã dồn hết vào hai tiếng không trọn nghĩa: “ông... cháu”.\n" +
                    "\n" +
                    "Sáng hôm sau tôi và mẹ phải đi. Tôi mang theo trong lòng nỗi băn khoăn không biết ông đã cố hết sức nói với tôi điều gì. Mãi cho đến một tuần sau khi trở về nhà, tôi mới rõ những gì ông muốn nói.\n" +
                    "\n" +
                    "Một cô y tá làm việc ở bệnh viện nơi ông đang điều trị đã gọi điện thoại cho gia đình tôi. Cô nhắn lại nguyên văn lời ông tôi nhờ nói lại:\n" +
                    "\n" +
                    "“Hãy gọi giúp cho cháu gái của tôi và nói với nó rằng ” yêu”\n" +
                    "\n" +
                    "Thoạt tiên, tôi cảm thấy dường như có cái gì đó nhầm lẫn. Tại sao ông chỉ nói một chữ “yêu” không thôi? Tại sao ông lại không nói “ông yêu cháu”? Rồi tôi chợt bừng tỉnh và nhớ ra. Vậy là điều mà ông cố nói ra thành lời trong cái ngày tôi và mẹ thăm ông ở bệnh viện là câu “Ông yêu cháu”. Tôi thật sự cảm động. Tôi cảm thấy mình như sắp khóc, và tôi khóc thật.\n" +
                    "\n" +
                    "Trải qua nhiều tuần chịu đau đớn, cuối cùng ông cũng nói lại được. Tôi gọi điện cho ông mỗi tối. Bình thường cứ nói chuyện được khoảng 5 phút thì ông phải ngừng lại bởi ông vẫn chưa khỏe lắm. Nhưng trước khi gác máy, bao giờ ông cũng nói câu “ông yêu cháu” và “Ông sẽ làm bất cứ điều gì cho cháu”. Những lời này cùng lời bộc bạch cảm động của ông “Cháu là lẽ sống duy nhất của ông” là những lời hay nhất mà tôi từng nhận được trong cuộc đời!\n" +
                    "\n" +
                    "Ông sẽ chẳng thể nào khỏe mạnh lại được như xưa và tôi biết thời gian gần nhau của hai ông cháu không còn nhiều. Tôi cảm thấy vinh dự vì được ông chọn làm người để chia sẻ những cảm xúc của ông. Tình yêu thương mà ông dành cho tôi sâu sắc biết bao! Ba từ “Ông yêu cháu” nghe tưởng chừng đơn giản nhưng thật ra không đơn giản chút nào. Đó là một lẽ sống trong đời.',2,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Những chiến binh tí hon','Hãy nhìn lại cuộc đời mình trong những giờ phút kiên gan chống chọi với nghịch cảnh, bạn sẽ thấy rằng: những khoảnh khắc bạn sống thực sự là những lúc bạn làm điều gì đó bằng tình yêu.\n" +
                    "\n" +
                    "- Henry Drummond\n" +
                    "\n" +
                    "Tôi dự định chuyển đội quân nhỏ của mình đến một nơi tốt hơn tuyến lửa này. Là một người mẹ đơn thân 27 tuổi, một nách bốn đứa con thơ, tôi quen với ý nghĩ rằng mình đích thị là một người chỉ huy can trường chăn dắt lũ con của tôi. Thật ra thì đời sống của chúng tôi có khác gì đang trong một trại huấn luyện tân binh đầy khắc nghiệt đâu? Cả năm mẹ con chúng tôi phải chen chúc trong một nơi kín bít bùng - một căn hộ có hai phòng ngủ ở bang New Jersey - với những quy định nghiêm ngặt tự đặt ra về đồ ăn thức uống. Tôi đã không thể lo đủ cho các con mình ngay cả những nhu cầu thiết yếu hàng ngày như những bậc cha mẹ khác, và ngoài mẹ tôi ra, không ai khác trong gia đình tôi chịu ngó ngàng, quan tâm đến cuộc sống của lũ trẻ con tôi cả.\n" +
                    "\n" +
                    "Tất cả đều trút lên đôi vai tôi, một thân trơ trọi nhận lãnh vai trò của người tổng chỉ huy đội quân của mình. Nhiều đêm, tôi thao thức hoạch định những chiến lược để cuộc sống của các con tôi được đầy đủ hơn. Dù chúng chưa bao giờ phàn nàn về sự thiếu thốn và dường như rất yên tâm sống dưới sự đùm bọc thương yêu của tôi, tâm trí tôi vẫn cứ luôn thôi thúc, nhìn trước trông sau, xoay đầu này, trở đầu kia, tìm mọi cách để cải thiện cuộc sống đạm bạc của chúng. Cho nên khi tìm thấy một căn hộ có năm phòng ngủ trong ngôi nhà ba tầng - tầng hai và ba hoàn toàn thuộc về chúng tôi - tôi đã chóp ngay cơ hội này. Vậy là cuối cùng chúng tôi có thể thoải mái hơn. Ngôi nhà này thậm chí có cả một sân sau khá rộng rãi.\n" +
                    "\n" +
                    "Bà chủ nhà hứa sẽ sửa chữa mọi thứ trong vòng một tháng. Tôi đồng ý và trả ngay bằng tiền mặt tiền thuê tháng đầu tiên và luôn cả tiền bảo vệ an ninh, rồi vội vã ra về báo cho ‘lính’ của tôi biết rằng chúng tôi sắp chuyển đi. Lũ nhóc mừng rơn và rất phấn khởi. Đêm đó tất cả chúng tôi nằm co cụm trên giường, tính toán những điều phải làm cho tổ ấm mới.\n" +
                    "\n" +
                    "Sáng hôm sau, tôi thông báo cho người chủ nhà nơi chúng tôi đang ở rồi bắt đầu gói ghém đồ đạc. Chúng tôi chất những thùng đồ một cách nhanh chóng và gọn gàng. Nhìn đội quân của tôi làm việc, lòng tôi cũng thấy ấm áp.\n" +
                    "\n" +
                    "Lũ lượt kéo đến nơi, tôi mới chợt nhận ra sai lầm chết người của mình. Tôi đã không có chìa khóa của căn nhà này. Rồi hết ngày này qua ngày khác, với những cú điện thoại không người nhấc máy và những lần kiếm cách đột nhập vào căn nhà đều thất bại, tôi bắt đầu phát hoảng. Tôi gọi điện thoại cho công ty địa ốc hỏi thăm. Họ cho biết là ngôi nhà này đã có người khác thuê. Tôi đã bị lừa.\n" +
                    "\n" +
                    "Mặt mày méo xệch, tôi đưa mắt nhìn những khuôn mặt háo hức của các con và cố tìm lời để nói với chúng về tin chẳng lành này. Chúng đón nhận một cách bình thản mặc dù bản thân tôi thì chỉ muốn khóc vì thất vọng.\n" +
                    "\n" +
                    "Với tâm trạng não nề của kẻ bại trận, tôi lại đối mặt với những khó khăn còn tồi tệ hơn nữa. Nhà cũ thì không thể quay về. Bao nhiêu tiền tôi có đã dốc sạch cho nơi ở mới này rồi, còn đâu nữa để tính chuyện đi thuê nơi ở khác. Mẹ tôi cũng muốn giúp đỡ, nhưng với điều kiện bọn trẻ không được phép vào căn hộ nhỏ của bà. Quá thất vọng, tôi quay sang nhờ một người bạn giúp đỡ. Chị ấy cũng là một “cựu chiến binh” như tôi: một mình nuôi năm người con và cũng đang vật lộn với cuộc sống không khác gì tôi. Chị ấy cố gắng hết mức để chứng tỏ lòng hiếu khách. Nhưng chín đứa trẻ trong bốn phòng... Thử hình dung xem, tôi chắc các bạn hiểu được hoàn cảnh bi đắt của chúng tôi rồi.\n" +
                    "\n" +
                    "Sau ba tuần, tất cả đều không chịu nổi. Chúng tôi phải ra đi. Chẳng còn sự lựa chọn nào khác và tôi cũng chẳng biết làm gì hơn. Chúng tôi phải cuốn gói thôi. Tôi gom hết đồ đạc, nhét những quần áo ấm của mấy mẹ con vào cốp sau chiếc ô tô cũ ký màu vàng của mình, và thông báo cho những chiến binh tí hon rằng giờ đây chúng tôi không có nơi nào để trú chân ngoài chiếc xe hơi.\n" +
                    "\n" +
                    "Hai con trai tôi, đứa lên 6 và đứa lên 10, nhìn tôi và chăm chú lắng nghe.\n" +
                    "\n" +
                    "- Tại sao chúng ta không ở nhà bà hả mẹ? - Đứa lớn nhất hỏi.\n" +
                    "\n" +
                    "Theo sau câu hỏi đó là một lô một lốc các đề nghị của những đứa khác về những nơi mà chúng tôi có thể ở. Với mỗi lời đề nghị, tôi đều phải trả lời về một sự thật khắc nghiệt.\n" +
                    "\n" +
                    "- Mỗi người đều có cuộc sống riêng, các con ạ. Chúng ta phải tự lo cho mình. Chúng ta có thể làm được mà!\n" +
                    "\n" +
                    "Nhưng nếu như thái độ tự tin và đầy thuyết phục của tôi làm chúng yên tâm thì những lý lẽ đó không thể lừa phỉnh được tôi. Tôi cần phải có thêm sức mạnh. Mà tôi biết trông cậy điều đó ở ai bây giờ?\n" +
                    "\n" +
                    "Đến giờ đi ngủ, tôi tập hợp những chiến binh tí hon của mình lại và tiến về nơi đóng quân - chiếc xe của mẹ con tôi. Đám trẻ ngoan ngoãn vâng lời, nhưng đầu óc tôi lại cứ tập trung vào “tình hình chiến sự ác liệt” trước mắt. Tôi có nên làm thế này với các con mình không? Mà thực ra tôi có thể làm gì khác được trong tình thế hiện nay?\n" +
                    "\n" +
                    "Thật bất ngờ, chính đội quân nhỏ của tôi đã mang cho tôi sức mạnh mà tôi đang cần. Bốn tuần kế tiếp chúng tôi phải sống trong xe hơi, tắm rửa tại nhà mẹ tôi vào buổi sáng và ăn uống tại những quầy thức ăn nhanh. Bọn trẻ dường như thích thú với lề thói kỳ quặc này. Chúng không bỏ học ngày nào, không phàn nàn và cũng chẳng hạch hỏi gì về quyết định của tôi. Chúng tin tưởng hoàn toàn vào sự khôn ngoan của người chỉ huy đến nỗi tôi bắt đầu thấy mình trở nên can đảm. Chúng tôi có thể vượt qua mà! Mỗi đêm chúng tôi dừng xe tại một điểm khác nhau, những khu vực đèn thắp sáng trưng gần các tòa nhà. Khi trời trở lạnh, bọn trẻ rúc vào băng ghế sau đã được hạ xuống để làm giường, chia sẻ nhau hơi ấm của cơ thể và các tấm mền. Tôi ngồi ghế trước, chập chờn trong giấc ngủ để thỉnh thoảng còn kịp tỉnh dậy nổ máy xe để dùng bộ phận sưởi của xe sưỏi ấm cho tất cả chúng tôi.\n" +
                    "\n" +
                    "Khi tôi kiếm được đủ tiền để thuê một căn hộ thì không nơi nào chấp nhận bốn đứa trẻ, vì thế chúng tôi đăng ký ở trọ tại khách sạn. Thật tuyệt vời! Chẳng khác gì một kỳ nghỉ phép trong quân đội. Chúng tôi hồi hộp, mừng vui khi có hệ thống sưỏi, những chiếc giường và cả sự an toàn. Chúng tôi lén lấy thức ăn của mình ra nấu nướng và học cách chuẩn bị những bữa ăn ngon miệng bằng cái bếp hai lò. Chúng tôi làm lạnh những món bơ sữa trong bồn tắm bởi khách sạn có rất nhiều đá.\n" +
                    "\n" +
                    "Cuối cùng, sau nhiều tháng, người chủ căn nhà đầy hứa hẹn ngày trước gửi một lệnh phiếu trả lại tất cả số tiền của tôi và hết lời xin lỗi. Tôi đã dùng số tiền này tìm thuê một căn hộ khác.\n" +
                    "\n" +
                    "Chuyện đó xảy ra cách nay đã 13 năm. Giờ đây, tôi đang chia sẻ quyền chỉ huy với một người chồng, và bọn trẻ được chúng tôi chăm sóc chu đáo trong một ngôi nhà rộng rãi. Mỗi sáng, khi đi kiểm tra đội quân của mình, giờ đã cao gần bằng tôi, tôi nhớ đến sự tuyệt vọng ngày nào, kẻ thù khủng khiếp mà chúng tôi đã cùng nhau chiến đấu và chiến thắng. Tôi cảm tạ ơn trên đã ban cho tôi những chiến binh tí hon này - đội quân bé nhỏ lì lợm, dũng cảm - những chiến binh chẳng bao giờ biết khiếp sợ trong cuộc hành quân ghê gơm đó. Lòng can đảm của chúng chính là chất liệu làm nên điều vĩ đại nhất của các anh hùng.',3,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cát và Đá','Có hai người bạn đang dạo bước trên sa mạc. Trong chuyến đi dài, hai người nói chuyện với nhau và đã có một cuộc tranh cãi gay gắt.\n" +
                    "\n" +
                    "Không giữ được bình tĩnh, một người đã tát người bạn của mình. Người kia rất đau nhưng không nói gì. Anh chỉ lặng lẽ viết lên cát rằng: \"Hôm nay, bạn tốt nhất của tôi đã tát vào mặt tôi.\"\n" +
                    "\n" +
                    "Họ tiếp tục bước đi cho tới khi nhìn thấy một ốc đảo, nơi họ quyết định sẽ dừng chân và tắm mát.\n" +
                    "\n" +
                    "Người bạn vừa bị tát do sơ ý bị trượt chân xuống một bãi lầy và ngày càng lún sâu xuống. Nhưng người bạn kia đã kịp thời cứu anh.\n" +
                    "\n" +
                    "Ngay sau khi hồi phục, người bạn suýt chết đuối khắc lên tảng đá dòng chữ: \"Hôm nay, bạn tốt nhất của tôi đã cứu sống tôi.\"\n" +
                    "\n" +
                    "Người bạn kia hết sức ngạc nhiên bèn hỏi: \"Tại sao khi tớ làm cậu đau, cậu lại viết lên cát còn bây giờ lại là một tảng đá?\"\n" +
                    "\n" +
                    "Và câu trả lời anh nhận được là: \"Khi ai đó làm chúng ta đau đớn, chúng ta nên viết điều đó lên cát nơi những cơn gió của sự thứ tha sẽ xóa tan những nỗi trách hờn.\n" +
                    "\n" +
                    "Nhưng \"Khi chúng ta nhận được điều tốt đẹp từ người khác, chúng ta phải ghi khắc chuyện ấy lên đá nơi không cơn gió nào có thể cuốn bay đi.\"\n" +
                    "\n" +
                    "Hãy học cách viết những nỗi đau lên cát và khắc tạc những niềm vui và hạnh phúc bạn tận hưởng trong cuộc đời lên tảng đá để mãi không phai.\n',4,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Câu chuyện về 2 hạt lúa','ó hai hạt lúa nọ được giữ lại để làm hạt giống cho vụ sau vì cả hai đều là những hạt lúa tốt, đều to khỏe và chắc mẩy.\n" +
                    "Một hôm, người chủ định đem chúng gieo trên cánh đồng gần đó. Hạt thứ nhất nhủ thầm: “ Dại gì ta phải theo ông chủ ra đồng. Ta không muốn cả thân mình phải nát tan trong đất. Tốt nhất ta hãy giữ lại tất cả chất dinh dưỡng trong lớp vỏ này và tìm một nơi lý tưởng để trú ngụ.” Thế là nó chọn một góc khuất trong kho lúa để lăn vào đó.\n" +
                    "Còn hạt lúa thứ hai thì ngày đêm mong được ông chủ mang gieo xuống đất. Nó thật sự sung sướng khi được bắt đầu một cuộc đời mới.\n" +
                    "Thời gian trôi qua, hạt lúa thứ nhất bị héo khô nơi góc nhà bởi vì nó chẳng nhận được nước và ánh sáng. Lúc này chất dinh dưỡng chẳng giúp ích được gì- nó chết dần chết mòn. Trong khi đó, hạt lúa thứ hai dù nát tan trong đất nhưng từ thân nó lại mọc lên cây lúa vàng óng, trĩu hạt. Nó lại mang đến cho đời những hạt lúa mới...\n" +
                    "\n" +
                    "Đừng bao giờ tự khép mình trong lớp vỏ chắc chắn để cố giữ sự nguyên vẹn vô nghĩa của bản thân mà hãy can đảm bước đi, âm thầm chịu nát tan để góp cho cánh đồng cuộc đời một cây lúa nhỏ - đó là sự chọn lựa của hạt giống thứ hai.\n" +
                    "\n" +
                    "Tôi hy vọng đó cũng sẽ là sự lựa chọn của bạn và tôi khi đứng trước cánh đồng cuộc đời bao la này...',5,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Câu chuyện về con Bướm','Một người tìm thấy một cái kén bướm. Đến ngày nọ, một cái lỗ nhỏ xuất hiện. Anh ngồi chăm chú theo dõi con bướm trong vài giờ đồng hồ khi nó vùng vẫy tìm cách chui ra ngoài qua cái lỗ nhỏ đó. Rồi dường như nó không có thêm một tiến triển nào nữa. Trông cứ như thể nó đã làm hết mức có thể rồi và không thể xoay xở gì thêm được.\n" +
                    "Vì vậy, người đàn ông quyết định giúp con bướm. Anh lấy một cái kéo và cắt cái kén.\n" +
                    "\n" +
                    "Khi ấy, con bướm dễ dàng thoát ra. Nhưng nó có một cái thân căng phồng và đôi cánh nhỏ bé, teo quắt.\n" +
                    "\n" +
                    "Người đàn ông tiếp tục quan sát con bướm bởi vì anh mong đợi rằng, đến một lúc nào đấy, đôi cánh của con bướm sẽ to lên và dang rộng ra để có thể nâng được phần thân, trong khi cùng lúc ấy phần thân sẽ nhỏ đi.\n" +
                    "\n" +
                    "Chẳng có điều gì xảy ra cả! Trong thực tế, con bướm dùng cả cuộc đời còn lại của nó bò loanh quanh với một cái thân căng phồng và những chiếc cánh nhăn nheo. Nó không bao giờ có thể bay được.\n" +
                    "\n" +
                    "Người đàn ông, tốt bụng nhưng hấp tấp, đã không hiểu rằng chiếc kén chật hẹp và sự chật vật của con bướm để chui qua được cái lỗ nhỏ ấy chính là cái cách mà Tạo Hóa buộc chất lỏng trong thân con bướm chảy vào cánh để sẵn sàng cho nó cất cánh bay ngay khi nó thoát khỏi cái kén và giành được sự tự do.\n" +
                    "Đôi khi, những cuộc đấu tranh chính xác là những gì chúng ta cần trong cuộc sống của mình. Nếu Tạo Hóa cho phép chúng ta trải qua cuộc sống mà không có bất kỳ trở ngại nào thì điều đó sẽ làm chúng ta trở nên “tàn tật”. Chúng ta sẽ không mạnh mẽ như đáng lẽ ra chúng ta đã có thể. Chúng ta sẽ không thể bay cao. ',6,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Điều bí ẩn giản dị của hạnh phúc','Chúng ta thường nghĩ rằng cuộc sống của mình sẽ tốt đẹp hơn sau khi việc học hành hoàn tất hay có gia đình, có công việc ổn định. Nhưng khi đã có được những điều ấy rồi, chúng ta lại bị chi phối bởi nhiều mối bận tâm và lo lắng khác nữa. Chúng ta thường không hài lòng khi cuộc sống không như những gì mình mong muốn. \n" +
                    "\n" +
                    "Có mấy ai nhận ra rằng khoảng thời gian hạnh phúc nhất chính là những giây phút hiện tại mà chúng ta đang sống? Cuộc sống vốn chứa đựng nhiều thử thách, khó khăn và nghịch cảnh. Cách thích ứng tốt nhất với cuộc sống này là chấp nhận thực tế và tin vào chính mình. Tự bản thân mỗi chúng ta, trong bất kỳ hoàn cảnh nào, phải biết cảm nhận và tự tìm lấy niềm hạnh phúc cho riêng mình. \n" +
                    "\n" +
                    "Đừng trông đợi một phép màu hay một ai đó sẽ mang hạnh phúc đến cho bạn. Đừng đợi đến khi bạn thật rảnh rỗi hay đến lúc tốt nghiệp ra trường, đừng đợi đến khi kiếm được thật nhiều tiền, thành đạt, có gia đình, hoặc đến khi được nghỉ hưu mới thấy đó là lúc bạn được hạnh phúc. \n" +
                    "\n" +
                    "Đừng đợi đến mùa xuân, mùa hạ, mùa thu, hay mùa đông rồi mới cảm thấy hạnh phúc. Đừng đợi tia nắng ban mai hay ánh hoàng hôn buông xuống mới nghĩ là hạnh phúc. Đừng đợi đến những chiều thứ bảy, những ngày cuối tuần, ngày nghỉ, ngày sinh nhật hay một ngày đặc biệt nào mới thấy đó là ngày hạnh phúc của bạn. Tại sao không phải lúc này? \n" +
                    "\n" +
                    "Hạnh phúc là một con đường đi, một hành trình. Hãy trân trọng từng khoảnh khắc quý giá trên chuyến hành trình ấy. hãy dành thời gian quan tâm đến người khác và luôn nhớ rằng, thời gian không chờ đợi một ai! Nhưng chắc chắn không bao giờ là quá muộn - và thời gian là người bạn tốt nhất của bạn, của tất cả mọi người. \n" +
                    "\n" +
                    "- Hãy làm việc say mê như thể bạn không còn cơ hội để làm lại một lần nữa. \n" +
                    "\n" +
                    "- Hãy yêu chân thành và trọn vẹn như thễ bạn chưa từng đau khổ vì tình yêu. \n" +
                    "\n" +
                    "- Bạn hãy đón nhận cuộc sống với tất cả những điều bình dị, tinh khôi nhất của nó, như thể bạn chưa từng trải qua những năm tháng khổ đau, những phút giây tuyệt vọng. Như thể bạn vừa khám phá được ý nghĩa thật sự của tình yêu, và hơn hết là điều bí ẩn giản dị của hạnh phúc.',7,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tình Yêu Và Cốc Nước Trắng','Một chàng trai đưa cô bạn gái thân vào quán uống nước. Sau khi người phục vụ đặt hai cốc nước trắng lên bàn và đợi thì cô gái chợt đặt ra một câu hỏi: \n" +
                    "\n" +
                    "- Đố bạn Tình yêu là gì? \n" +
                    "\n" +
                    "Chàng trai mỉm cười quay sang cô phục vụ và nói: \n" +
                    "\n" +
                    "- Chị cho em một ấm trà, một cốc cà phê đen, một cốc cà phê sữa, một ly rượu vang và một ly champagne. \n" +
                    "Sau khi mọi thứ đã được mang ra, chàng trai lấy ấm trà và uống chén đầu tiên. Anh ta nói: \n" +
                    "\n" +
                    "- Tình yêu như ấm trà này. Khi ta uống nước đầu sẽ rất đậm đà, nước thứ hai sẽ dìu dịu thanh thanh. Còn nước thứ ba thì sao? \n" +
                    "\n" +
                    "Tình yêu không như ấm trà bởi sau nước thứ ba ấm trà sẽ không còn hương vị ban đầu. \n" +
                    "\n" +
                    "Anh ta lại nhấp một ngụm cà phê đen và nói: \n" +
                    "\n" +
                    "- Tình yêu mang hương vị của cốc cà phê này. Lúc đầu có thể phải trải qua vị đắng nhưng dần dần vị ngọt và thơm sẽ ngấm dần vào mỗi người. \n" +
                    "\n" +
                    "- Nhưng tình yêu không như cốc cà phê sữa. Uống cà phê sữa ta sẽ cảm thấy ngay vị ngọt, vị ngọt của nó đến rất nhanh và đi rất nhanh. Còn tình yêu không như vậy. \n" +
                    "\n" +
                    "Dứt lời anh ta đổ cốc cà phê ấy đi và nói: \n" +
                    "\n" +
                    "- Tình yêu như ly rượu này, nó thật nồng nàn, ấm áp và êm đềm. \n" +
                    "\n" +
                    "Anh ta lại uống ly champagne. \n" +
                    "\n" +
                    "- Không! Tình yêu không thể là thứ nước khai vị chua loét này được. \n" +
                    "\n" +
                    "Chàng trai lo lắng vì không tìm được câu trả lời. Bất chợt anh ta nhìn thấy cốc nước trắng trên bàn. Anh ta reo lên. \n" +
                    "\n" +
                    "- Đúng rồi, hãy nhìn cốc nước kia, nó thật tinh khiết và giản dị. Rượu, cà phê và trà cũng phải bắt nguồn từ nước. Tình yêu cũng như vậy, cái nồng nàn, ngọt ngào, êm đềm và cay đắng cũng phải xuất phát từ lòng chân thành và những điều giản dị nhất. Bạn ạ! \n" +
                    "\n" +
                    "Tình yêu là cốc nước trắng. \n" +
                    "\n" +
                    "Cô gái ngồi im, đôi mắt mở to. \n" +
                    "\n" +
                    "Và rồi cô từ từ nhấc ly nước lên và từ từ đặt vào tay chàng trai. \n" +
                    "\n" +
                    "Chàng trai đã hiểu rằng, anh ta đã có một câu trả lời đúng...\n',8,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bài Học Cho Tình Bạn','Ở ngôi làng kia có một chú bé tuổi độ mười sáu . Chú là một chú bé thông minh, tốt bụng, có những suy nghĩ khá sâu sắc so với lứa tuổi của chú. Thế nhưng, chú lại thiếu lòng tin và hay buồn rầu, chú luôn cảm thấy mình thiếu bạn...\n" +
                    "\n" +
                    "Một ngày kia, như thường lệ, chú lại cảm thấy buồn chán và không có chuyện gì làm, chú lang thang một mình dọc theo bờ biển, lẩm bẩm tự than với mình:\n" +
                    "\n" +
                    "Chán quá đi...Ta buồn chẳng hiểu vì sao ta buồn? Chẳng có ai hiểu ta! Chẳng có ai làm bạn với ta và thật sự coi ta là bạn...!!!\n" +
                    "\n" +
                    "Vô tình chú giẫm phải vật gì đó dưới chân. Cuối xuống xem, chú thấy đó là một con sò nhỏ có lớp vỏ rất đẹp với nhiều màu sắc. Chú thờ ơ bỏ nó vào túi dự định đem về nhà chơi và định đi tiếp. Thình lình, con sò bỗng cất tiếng nói:\n" +
                    "\n" +
                    "Bạn ơi...Hãy thả tôi về với biển...Hãy giúp tôi trở về với nơi sinh ra mình...Có thể tôi không có gì để tặng lại bạn, nhưng tôi sẽ cho bạn một lời khuyên...!!!\n" +
                    "\n" +
                    "Cậu bé vừa ngạc nhiên, vừa sợ hãi, lại vừa thích thú. Nhìn con sò, cậu nói:\n" +
                    "\n" +
                    "Được thôi, ta sẽ thả bạn về với biển, nhưng...hãy cho ta một lời khuyện trước đi...Ta đang buồn chán vì không có bạn bè đây!\n" +
                    "\n" +
                    "Con sò cất tiếng trả lời bằng một giọng nói chậm rãi, nhẹ nhàng:\n" +
                    "\n" +
                    "Bạn hãy nhìn những hạt cát dưới chân bạn và nắm một nắm cát đầy đi. Bạn biết không, nắm cát trong lòng bàn tay của bạn cũng giống như bạn bè của bạn vậy. Những hạt cát quá xa lòng bàn tay bạn sẽ theo kẻ hở giữa những ngón tay bạn mà rơi ra ngoài. Nếu bạn càng siết chặt bàn tay thì chúng càng rơi ra nhiều hơn. Chỉ có những hạt cát nằm giữa lòng bàn tay bạn, được giữ chặt trong đó mới còn lại mà thôi. Đó chính là những người bạn thân thiết mà chúng ta thật sự cần, những người bạn này sẽ ở lại với ta dù bất cứ chuyện gì xảy ra. Nhưng, bạn thấy đó, những hạt cát này rất ít và dễ dàng rơi ra nếu ta không biết giữ gìn. Hãy đem chúng về và ngâm trong những vỉ màu đẹp nhất. Hãy giữ gìn và nâng niu chúng bằng tình cảm của mình. Chúng sẽ ở bên cạnh bạn và không rời xa đâu. Tôi chỉ có thể khuyên bạn như vậy thôi...\n" +
                    "\n" +
                    "Chú bé im lặng, thả con sò về lại với lòng biển xanh bao la mà không nói lời nào...Chú còn mải suy nghĩ về những điều con sò nhỏ nói...',9,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Khoảnh Khắc Và Cuộc Sống','Đôi khi có một số người lướt qua cuộc đời bạn và ngay tức khắc bạn nhận ra rằng sự có mặt của họ ý nghĩa như thế nào. Họ đã dạy bạn những bài học, đã giúp bạn nhận ra giá trị của chính mình hoặc trở thành con người mà bạn từng mơ ước. Có lẽ bạn sẽ không biết được những con người này từ đâu đến ( bạn cùng phòng, người hàng xóm, vị giáo sư, người bạn mất liên lạc từ lâu hay thậm chí là một người hoàn toàn xa lạ ). Nhưng khi bạn thờ ơ với họ, hãy nhớ rằng trong từng khoảnh khắc họ sẽ ảnh hưởng rất sâu sắc đến cuộc đời bạn.\n" +
                    "\n" +
                    "Ban đầu sự việc xảy ra trông có vẻ kinh khủng, đau khổ và bất công, nhưng khi lấy tấm gương của cuộc đời ra để đối chiếu, bạn sẽ hiểu được là nếu không có những giây phút ấy để bạn vượt qua mọi khó khăn thì bạn khó có thể thấy được tài năng, sức mạnh, ý chí và tấm lòng của bạn. Mọi việc đều diễn ra có chủ đích mà không có gì gọi là tình cờ hay may rủi cả. Bệnh tật, tổn thương trong tình yêu, giây phút tuyệt vời nhất của cuộc sống bị đánh cắp hoặc mọi thứ ngu ngốc khác đã xảy đến với bạn, hãy nhớ rằng đó là bài học quý giá. Nếu không có nó cuộc đời này chỉ là một lối đi thẳng tắp, một con đường mà không hề có đích đến cũng như bạn sống từng ngày mà không hề ước mơ. Thật sự con đường đó rất an toàn và dễ chịu, nhưng sẽ rất nhàm chán và vô nghĩa.\n" +
                    "\n" +
                    "Những người bạn gặp sẽ ảnh hưởng đến đến cuộc đời bạn. Thành công hay thất bại, thậm chí là những kinh nghiệm tồi tệ nhất cũng chính là bài học đáng giá nhất, sẽ giúp bạn nhận ra được giá trị của chính mình. Nếu có ai đó làm tổn thương bạn, phản bội bạn hay lợi dụng tấm lòng của bạn, hãy tha thứ cho họ bởi vì chính họ đã giúp bạn nhận ra được ý nhĩa của sự chân thật và hơn nữa, bạn biết rộng mở tấm lòng với ai đó. Nhưng nếu có ai thương yêu bạn chân thành, hãy yêu thương họ một cách vô điều kiện, không chỉ đơn thuần là họ đã yêu bạn mà họ đang dạy bạn cách để yêu .\n" +
                    "\n" +
                    "Hãy trân trọng khoảnh khắc và hãy ghi nhớ từng khoảnh khắc những cái mà sau này bạn không còn có cơ hội để trải qua nữa. Tiếp xúc với những người mà bạn chưa từng nói chuyện, và biết lắng nghe. Hãy để trái tim biết yêu thương người khác. Bầu trời cao vời vợi vì thế hãy ngẩng đầu nhìn lên, tự tin vào bản thân. Hãy lắng nghe nhịp đập của trái tim mình :\"Bạn là một cá nhân tuyệt vời. Tự tin lên và trân trọng bản thân bạn, vì nếu bạn không tin bạn thì ai sẽ làm điều ấy ?\".\n" +
                    "\n" +
                    "Hãy sở hữu cuộc sống của bạn và đừng bao giờ hối tiếc về lối sống ấy. Nếu bạn thương yêu ai đó thì hãy nói cho họ biết, dù rằng sẽ bị từ chối nhưng nó có thể làm cho một trái tim tan nát có thể đập trở lại.',10,2)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Câu Chuyện Chiếc Bình','Một giáo sư đang trong giờ giảng về cách quản lý thời gian. Ông đặt vài thứ trước mặt. Đầu tiên, ông lấy một cái bình to và bắt đầu cho vào đó những quả bóng chơi golf. Sau đó, ông hỏi các sinh viên: “Theo các bạn, bình đã đầy chưa?”. “Rồi ạ!”, các sinh viên trả lời.\n" +
                    "Giáo sư lại lấy ra một hộp đựng đầy bi và đổ vào bình. Rồi lắc lên cho bi rơi lấp vào khoảng trống giữa những quả bóng. Ông lại hỏi lần nữa và các sinh viên, lần này có vẻ ngập ngừng hơn, trả lời: “Có lẽ là rồi ạ.”\n" +
                    "\n" +
                    "Lần này, vị giáo sư lấy ra một xô cát, và cũng đổ vào bình. Tất nhiên, cát lấp đầy các khe hở. Ông hỏi lại và các sinh viên lần này đồng thanh: “Rồi ạ!”\n" +
                    "\n" +
                    "“Hãy xem này, “ giáo sư nói và lấy ra hai lon bia, đổ vào bình. Bia tràn vào giữa những hạt cát.\n" +
                    "\n" +
                    "“Bây giờ,” giáo sư nói, “tôi muốn các bạn hãy tưởng tượng cái bình này như cuộc đời của mình.\n" +
                    "\n" +
                    "Bóng golf tượng trưng cho những điều quan trọng – gia đình, con cái, sức khoẻ, bạn bè, đam mê - những điều mà nếu mọi thứ khác mất đi, thì chỉ mình chúng vẫn có thể làm cuộc sống của bạn đầy đủ.\n" +
                    "\n" +
                    "Những viên bi là thứ khác, nhỏ nhặt hơn - nghề nghiệp, nhà cửa, ôtô. Còn cát là những gì vặt vãnh còn lại.“\n" +
                    "\n" +
                    "“Nếu các bạn cho cát vào trước”, giáo sư tiếp tục, “sẽ không còn chỗ cho bi và bóng golf nữa. Cuộc đời cũng vậy. Nếu dành tất cả thời gian và năng lượng cho những việc vặt vãnh, bạn sẽ không bao giờ làm được những điều quan trọng.\n" +
                    "\n" +
                    "Hãy ưu tiên làm những việc thực sự cần thiết trước. Dành thời gian cho con cái, kiểm tra sức khỏe, đi ăn với gia đình, làm những việc mình thích. Sau khi đã làm tất cả những điều đó, chắc chắn bạn vẫn còn thời gian cho những thứ nhỏ nhặt như lau dọn nhà cửa, sửa chữa đồ đạc. Vì thế, hãy luôn ưu tiên những quả bóng, và đặt chúng vào bình trước tiên.”\n" +
                    "\n" +
                    "Khi người thầy dừng lại, lớp học vẫn im lặng một hồi. Bỗng có cánh tay giơ lên, và một sinh viên hỏi: “Thưa giáo sư, vậy bia tượng trưng cho cái gì?”\n" +
                    "\n" +
                    "Giáo sư mỉm cười hài lòng, “Một câu hỏi hay. Bia, tôi chỉ muốn nói với các bạn rằng, ngay cả khi các bạn thấy cuộc sống của mình đã quá bận rộn và đầy đủ thì, vẫn luôn còn thời gian cho một chầu bia!”\n" +
                    "\n" +
                    "Khi thấy mình có quá nhiều việc phải giải quyết, và 24 giờ mỗi ngày là không đủ, thì bạn hãy nghĩ đến chiếc bình này, đặt những quả bóng vào trước. Và... đừng quên những cốc bia!',11,2)");

            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Vết Thương','Một cậu bé nọ có tính hay nổi nóng. Một hôm cha của cậu bé đưa cho cậu một túi đinh và nói với cậu:\n" +
                    "\n" +
                    "- Mỗi khi con muốn nổi nóng với ai đó thì hãy chạy ra sau nhà và đóng một cây đinh lên chiếc hàng rào gỗ.\n" +
                    "\n" +
                    "Ngày đầu tiên cậu bé đã đóng hơn một chục cây đinh lên hàng rào gỗ. Và cứ thế số đinh tăng dần. Nhưng vài tuần sau cậu bé đã tập kềm chế dằn cơn nóng giận của mình và số lượng đinh phải đóng mỗi ngày ít đi. Cậu nhận thấy rằng kềm chế cơn giận của mình dễ hơn là phải đi đóng đinh lên hàng rào.\n" +
                    "\n" +
                    "Đến một ngày, cậu đã không nổi giận một lần nào suốt cả ngày. Cậu đến thưa với cha và ông bảo :\n" +
                    "\n" +
                    "- Tốt lắm, nếu bây giờ con tự dằn lấy được và không nổi nóng một lần thì con hãy nhổ một cây đinh ra khỏi hàng rào.\n" +
                    "\n" +
                    "Ngày lại ngày trôi qua, rồi cũng đến một hôm cậu bé đã vui mừng hãnh diện tìm cha mình báo rằng trên hàng rào đã không còn cây đinh nào cả.\n" +
                    "Người cha nói nhỏ nhẹ với cậu :\n" +
                    "\n" +
                    "-Con đã làm rất tốt, nhưng con hãy nhìn những lỗ đinh con để lại trên hàng rào.\n" +
                    "\n" +
                    "Hàng rào đã không giống như xưa nữa rồi. Nếu con nói điều gì trong cơn giận dữ, những lời nói ấy cũng giống như những lổ đinh này, chúng để lại những vết thương khó rất khó lành trong lòng người khác. Cho dù sau đó con có nói xin lỗi bao nhiêu lần đi nữa, vết thương dù lành nhưng vết sẹo cũng còn để lại mãi.\n" +
                    "\n" +
                    "Con hãy luôn nhớ: Vết thương tinh thần còn đau đớn hơn cả thể xác. Bạn bè ta, những người chung quanh ta là những viên đá quí. Họ giúp con cười và giúp con mọi chuyện. Họ nghe con than thở mổi khi con gặp khó khăn, cổ vũ con và luôn sẵn sàng mở trái tim mình ra cho con. Hãy nhớ lời cha...\n',1,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Giàu Và Nghèo','Một ngày nọ, người cha giàu có dẫn con trai đến một vùng quê để thằng bé thấy những người nghèo ở đây sống như thế nào. Họ tìm đến nông trại của một gia đình nghèo nhất nhì vùng. \"Đây là một cách để dạy con biết qúy trọng những người có cuộc sống cơ cực hơn mình\"\n" +
                    ".\n" +
                    "Người cha nghĩ đó là bài học thực tế tốt cho đứa con bé bỏng của mình. Sau khi ở lại và tìm hiểu đời sống ở đây, họ lại trở về nhà.\n" +
                    "\n" +
                    "Trên đường về, người cha nhìn con trai mỉm cười: \"Chuyến đi như thế nào hả con?\"\n" +
                    "- Thật tuyệt vời bố ạ!\n" +
                    "\n" +
                    "- Con đã thấy người nghèo sống như thế nào rồi đấy!\n" +
                    "\n" +
                    "- Ô, vâng.\n" +
                    "\n" +
                    "- Thế con rút ra được điều gì từ chuyến đi này? Đứa bé không ngần ngại:\n" +
                    "\n" +
                    "- Con thấy chúng ta có một con chó, họ có bốn. Nhà mình có một hồ bơi dài đến giữa sân, họ lại có một con sông dài bất tận. Chúng ta phải treo những chiếc đèn lồng vào vườn, họ lại có những ngôi sao lấp lánh vào đêm. Mái hiên nhà mình chỉ đến trước sân thì họ có cả chân trời. Chúng ta có một miếng đất để sinh sống và họ có cả những cánh đồng trải dài. Chúng ta phải có người phục vụ, còn họ lại phục vụ người khác. Chúng ta phải mua thực phẩm, còn họ lại trồng ra những thứ ấy. Chúng ta có những bức tường bảo vệ xung quanh, còn họ có những người bạn láng giềng che chở nhau…\n" +
                    "\n" +
                    "Đến đây người cha không nói gì cả. \"Bố ơi, con đã biết chúng ta nghèo như thế nào rồi…\"\n" +
                    "\n" +
                    "– cậu bé nói thêm. Rất nhiều khi chúng ta đã quên mất những gì mình đang có và chỉ luôn đòi hỏi những thứ gì không có. Cũng có những thứ không giá trị với người này nhưng lại là mong mỏi của người khác. Điều đó còn phụ thuộc vào cách nhìn và đánh giá của mỗi người. Xin đừng quá lo lắng, chờ đợi vào những gì bạn chưa có mà bỏ quên điều bạn đang có, dù là chúng rất nhỏ nhoi.\n" +
                    "\n',2,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Có công mài sắt..','Một trong những điều đáng khích lệ nhất mà bạn có thể làm là tự xác định chính mình - biết mình là ai, tin vào cái gì và muốn đi tới đâu.\n" +
                    "\n" +
                    "- Shiela Murray Bethel\n" +
                    "\n" +
                    "Joan Molinsky luôn ấp ủ ước mơ được đứng trên sân khấu với mong muốn mang lại những phút giây thư giãn cho mọi người. Tuy cô đã thành công đôi chút trong các cuộc thi tài năng ở địa phương nhưng cha mẹ cô vẫn không mấy tin tưởng quyết định chọn nghề diễn viên hài kịch của con mình là đúng.\n" +
                    "\n" +
                    "Buổi trình diễn đầu tiên của Joan ở New York là vào cuối hè tại một câu lạc bộ, bố mẹ cô cũng đến xem.\n" +
                    "\n" +
                    "Tiết mục bắt đầu bằng một bài hát vui nhộn, nhưng sự tập trung mà khán giả dành cho cô chỉ như sự lưu tâm khi chiếc xe đẩy chở thức ăn tráng miệng đi ngang qua bàn họ. Ba trăm con người mải chuyện trò huyên náo, chẳng ai chú ý gì đến nghệ sĩ trên sân khấu. Đau nhói và sượng sùng, Joan vẫn cố gắng kiên nhẫn vận dụng hết khả năng của mình để hoàn thành từng phần đoạn một. Sau lời “Cám ơn!” nhũn nhặn, Joan bỏ chạy vào nhà bếp, nước mắt rơi lã chã. Cha mẹ cô lúng túng - nhưng cho chính bản thân họ nhiều hơn là cho con gái. Thất bại này càng khiến cha của Joan, tiến sĩ Molinsky, kiên quyết khuyên cô từ bỏ giấc mơ gắn với ngành giải trí để đeo đuổi một ngành nghề khác thực tế hơn.\n" +
                    "\n" +
                    "- Nhưng đây là cuộc đời con và con quyết sống với nó đến cùng - Joan bương bỉnh.\n" +
                    "\n" +
                    "Cuộc tranh luận kết thúc bằng việc Joan rời gia đình đến thành phố New York. Cô thuê nhà, kiếm sống qua ngày và nuôi dưỡng ước mơ bằng cách tham gia sân khấu tạp ký. Sự tận tụy của cô cũng dần được đền đáp - sau này cô nhận được một chân biên kịch và là hoạt náo viên cho Candid Camera, một chương trình ít tiếng tăm ởCalifornia. Dù nỗ lực cách mấy, cô vẫn không bao giờ được ông bầu Alien Funt nhớ đúng tên, mà luôn bị gọi bằng bất cứ tên gì ông ta chợt nghĩ ra - từ Jeri, Jeannie cho đến Jackie...\n" +
                    "\n" +
                    "Một hôm, cô nhận được một cú điện từ The Tonight Show - nơi cô nộp đơn xin một vai nhỏ. Họ muốn cô xuất hiện chung với Johnny Carson, diễn viên hài kịch vĩ đại đương thời. Viện lý do bị bệnh để xin nghỉ một hôm ở Candid Camera, Joan quyết tâm nắm lấy vận hội này. Trên sân khấu, Joan và Carson lập tức diễn ăn ý với nhau ngay, thậm chí còn hay hơn cả kịch bản. Cuối vở, Carsonphấn khích hét to lên với hàng triệu khán giả qua màn ảnh nhỏ rằng:\n" +
                    "\n" +
                    "- Chà, cô tiếu lâm quá! Rồi cô sẽ trở thành ngôi sao cho mà xem!\n" +
                    "\n" +
                    "Ngày hôm sau, hàng tá lời mời biểu diễn tới tấp được gởi về từ khắp mọi miền đất nước, đưa Joan vào danh sách những diễn viên hài kịch hạng A. Sau cùng, cô cũng xin nghỉ ở Candid Camera, khiến ông Funt vừa giận dữ vừa hối tiếc. Nhai nhóp nhép củ cà rốt, ông ta bảo:\n" +
                    "\n" +
                    "- Tôi nghĩ là cô đã phạm một sai lầm lớn, Jill à!\n" +
                    "\n" +
                    "Đây là lần sau cùng cô bị gọi sai tên. Kể từ đó, cái tên Joan Molinsky luôn được xướng lên thật chính xác.\n" +
                    "\n" +
                    "Xa xa nơi đó, tận phía chân trời, là những ước mơ, hoài bão của tôi. Có thể tôi không bao giờ với tới chúng được, nhưng tôi có thể nhìn lên và ngắm vẻ đẹp của chúng, tin tưởng vào chúng và cố gắng thay đổi chúng.\n" +
                    "\n" +
                    "- Louisa May Alcott',3,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Không đầu hàng số phận','Nếu tôi có thể ước cho mình một cuộc sống không gặp trở ngại nào thĩ hấp dẫn thật đấy, nhưng tôi sẽ khước từ vì khi ấy tôi sẽ không học được điều gì từ cuộc sống nữa.\n" +
                    "\n" +
                    "- Allyson Jones\n" +
                    "\n" +
                    "Những khởi đầu của năm 1993 dường như báo hiệu đây không phải là năm tốt đẹp trong đời tôi. Đó là năm thứ tám tôi một thân một mình nuôi ba đứa con còn đang tuổi đi học, trong đó đứa con gái lớn chưa hôn ước gì cả vừa sinh cho tôi đứa cháu đầu tiên, còn tôi cũng sắp chia tay với người đàn ông tử tế sau hai năm hò hẹn.\n" +
                    "\n" +
                    "Tháng tư năm ấy, tôi được gọi đi phỏng vấn và viết bài về một người phụ nữ sống tại một thị trấn nhỏ ở bang Minnesota. Thế là, ngay trong mùa lễ Phục sinh, tôi cùng Andrew, con trai 13 tuổi của tôi, lái xe qua hai tiểu bang để đến gặp người phụ nữ có tên là Jan Turner.\n" +
                    "\n" +
                    "Trong chuyến đi dài đó, thỉnh thoảng tôi lại gọi chuyện với Andrew để lôi thằng bé ra khỏi những cơn ngủ gật.\n" +
                    "\n" +
                    "- Con biết không, cô ấy bị cụt cả hai chân tay.\n" +
                    "\n" +
                    "- Ô, thế thì làm sao cô ấy đi lại được nhỉ?\n" +
                    "\n" +
                    "- Chúng ta sẽ biết khi tới nơi.\n" +
                    "\n" +
                    "- Cô ấy có con không mẹ?\n" +
                    "\n" +
                    "- Hai con trai, chúng tên là Tyler và Coily - cả hai đều là con nuôi.\n" +
                    "\n" +
                    "- Chuyện gì đã xảy ra với cô ấy vậy mẹ?\n" +
                    "\n" +
                    "- Mẹ không rõ nữa. Trước khi phải cắt bỏ đi tay và chân, cô ấy đã từng là giáo viên thanh nhạc ở trường tiểu học và chỉ huy dàn đồng ca tại nhà thờ.\n" +
                    "\n" +
                    "Andrew lại thiếp đi trước khi tôi kể nốt cho nó nghe những thông tin ít ỏi mà tôi biết về Jan. Khi đến tiểu bang Minnesota, tôi chợt băn khoăn không hiểu người phụ nữ tôi sắp gặp mặt đã phản ứng ra sao khi nghe cái tin khủng khiếp là mình phải cắt bỏ cả hai tay hai chân như vậy. Làm sao cô ấy có thể sinh sống được? Có ai bên cạnh để giúp cô ấy không nhỉ?\n" +
                    "\n" +
                    "Khi đến Willmar, bang Minnesota, tôi gọi cho Jan từ khách sạn hỏi xem liệu tôi có thể đến nhà đón cô cùng lũ trẻ hay không.\n" +
                    "\n" +
                    "- Không sau đâu Pat, tôi lái xe được mà. Chúng tôi sẽ có mặt trong vòng 10 phút nữa. Chị có muốn đi ăn gì trước không? Gần chỗ chị có quán Ponderosa ăn cũng được lắm đấy.\n" +
                    "\n" +
                    "- Vâng, vậy cũng được. - Tôi nói mà trong lòng cũng thấy ngại ngùng. Không hiểu cùng ngồi ăn trong nhà hàng với một người phụ nữ không chân tay sẽ như thế nào nhỉ? Cô ấy lái xe thế nào được nhỉ? Tôi băn khoăn.\n" +
                    "\n" +
                    "Mười phút sau, Jan đỗ xe trước khách sạn. Cô xuống xe và đi về phía tôi với dáng đi rất bình thường trên đôi chân trông y như thật rồi chìa cánh tay phải có một cái móc sáng chói ở phía cuối để bắt tay tôi:\n" +
                    "\n" +
                    "- Chào Pat. Rất vui được gặp chị. Còn đây chắc là cháu Andrew.\n" +
                    "\n" +
                    "Tôi bóp nhẹ tay cô rồi cười gượng:\n" +
                    "\n" +
                    "- Vâng, đây là cháu Andrew.\n" +
                    "\n" +
                    "Sau đó, tôi nhìn ra băng ghế sau xe cô và cười với hai cậu bé, chúng cũng đang cười rất tươi với tôi.\n" +
                    "\n" +
                    "Jan vui vẻ ngồi vào sau tay lái.\n" +
                    "\n" +
                    "- Lên nào! Coily, xích vào cho bạn Andrew ngồi đi con.\n" +
                    "\n" +
                    "Chúng tôi vào nhà hàng, ăn uống và trò chuyện trong lúc bọn trẻ tán gẫu với nhau. Cả buổi tối hôm đó, việc duy nhất mà tôi phải làm giúp Jan Turner là mở nắp lọ xốt cà chua.\n" +
                    "\n" +
                    "Sau đó, trong khi lũ trẻ đang vui đùa trong hồ bơi của khách sạn, Jan và tôi ngồi trên bờ hồ. Cô kể cho tôi nghe về cuộc sống của cô trước khi xảy ra thảm kịch.\n" +
                    "\n" +
                    "- Hồi ấy, lúc nào tôi cũng bận rộn. Cuộc đời đẹp đến nỗi tôi đã nghĩ đến chuyện nhận nuôi thêm một đứa thứ ba.\n" +
                    "\n" +
                    "Tôi thấy lương tâm mình cắn rứt. Phải công nhận rằng người phụ nữ này sống tốt hơn là tôi nghĩ.\n" +
                    "\n" +
                    "Jan tiếp tục:\n" +
                    "\n" +
                    "- Một ngày chủ nhật trong tháng 11 năm 1989, tôi đang thổi kèn trumpet ở nhà thờ thì bất chợt thấy mệt, chóng mặt và buồn nôn. Tôi cố để không quy xuống ngay giữa buổi lễ, và hai cậu thanh niên đã đưa tôi về nhà khi buổi lễ vừa kết thúc. Tôi vào giường nằm nghỉ, nhưng đến tối tôi cảm thấy mình cần phải gọi cấp cứu ngay.\n" +
                    "\n" +
                    "Jan kể rằng lúc được đưa đến bệnh viện cô đã hôn mê. Huyết áp giảm đến nỗi cơ thể cô hoàn toàn tê liệt. Cô bị viêm phổi, một căn bệnh truyền nhiễm nguy hiểm do vi khuẩn gây nên. Một trong những ảnh hưởng phụ tai hại của căn bệnh này là sự kích hoạt hệ thống đông tụ của cơ thể, gây tắc nghẽn các mạch máu. Và vì máu đột ngột không chảy đến được các bàn tay và chân nên chân tay cô nhanh chóng bị hoại tử. Chỉ sau hai tuần nhập viện, tay Jan bị cưa đến khuỷu còn chân thì đến ống quyển.\n" +
                    "\n" +
                    "Ngay trước khi phẫu thuật, cô đã khóc lóc thảm thiết:\n" +
                    "\n" +
                    "- Ôi Chúa ơi! Không thể như thế được. Làm sao con có thể sống khi không có chân tay? Không đi được nữa ư? Không chơi trumpet, guitar, piano được nữa ư? Con sẽ không bao giờ được ôm các con của con hay chăm sóc chúng sao? Xin Thượng Đế đừng bắt con phải lệ thuộc vào người khác suốt quãng đời còn lại!\n" +
                    "\n" +
                    "Sau khi phẫu thuật được sáu tuần, các vết thương của cô đã lành, một bác sĩ đề cập với Jan việc dùng chân tay giả. Bà ấy bảo rằng Jan có thể tập đi, lái xe, đến trường và thậm chí cô còn có thể đi dạy lại.\n" +
                    "\n" +
                    "Jan cảm thấy điều đó thật khó tin. Trong lúc thất vọng, cô cầm quyển Kinh Thánh lên và mở ra một cách ngẫu nhiên. Một hàng chữ đập vào mắt cô, “Đừng bắt chước hành vi và thói quen của thế giới này. Hãy làm cho mình luôn mới mẻ và khác biệt trong những điều con làm và suy nghĩ. Con sẽ học từ chính kinh nghiệm của mình qua những điều giúp con thật sự hài lòng”.\n" +
                    "\n" +
                    "Jan đã suy nghĩ về điều đó - về việc trở thành một người mới mẻ và khác biệt - và cô quyết định thử dùng chân tay giả. Với cái khung tập đi buộc đến gần khuỷu tay và một bác sĩ trị liệu giúp đỡ, cô chỉ có thể loạng choạng trên đôi chân chừng hai ba phút trước khi ngã xuống trong đau đớn và kiệt sức.\n" +
                    "\n" +
                    "“Từ từ thôi”, Jan tự nhủ. “Hãy là một con người mới từ hành động đến suy nghĩ, nhưng làm từng bước một”.\n" +
                    "\n" +
                    "Ngày hôm sau, cô thử mang đôi tay giả, một hệ thống dây cáp thô, các dải cao su và những cái móc được vận hành bằng sợi đai quàng qua vai Jan. Bằng cách cử động các cơ vai, chẳng bao lâu cô có thể đóng mở những cái móc để nhặt và giữ đồ vật cũng như mặc quần áo và ăn uống.\n" +
                    "\n" +
                    "Trong vòng vài tháng, Jan có thể làm được hầu như mọi việc trước đây cô đã từng làm - chỉ khác là theo một cách mới mẻ và khác biệt mà thôi.\n" +
                    "\n" +
                    "- Tuy nhiên, khi được về nhà sau 4 tháng trị liệu, tôi vẫn cảm thấy bất an về cuộc sống của mình cùng các con. Nhưng khi về đến nơi, xuống xe rồi bước vào nhà và ôm chặt các con, tôi đã bỏ tất cả mọi lo lắng và ưu phiền sau lưng.\n" +
                    "\n" +
                    "Trong khi tôi và Jan tiếp tục trò chuyện, bé Coily leo khỏi bể bơi, đến gần rồi quàng tay ôm vai mẹ. Khi nghe mẹ kể về những tiến bộ mới trong việc nấu ăn của mình, Coily cười toe toét.\n" +
                    "\n" +
                    "- Mẹ cháu giỏi còn hơn cả trước khi bị bệnh nữa, vì bây giờ mẹ biết làm bánh kếp ngon tuyệt.\n" +
                    "\n" +
                    "Jan cười sung sưóng như người vừa được ban nguồn hạnh phúc lớn lao và được thỏa mãn trong cuộc sống.\n" +
                    "\n" +
                    "Sau chuyến viếng thăm của chúng tôi, Jan đã lấy thêm bằng đại học thứ hai ngành giao tế và trở thành phát thanh viên cho đài phát thanh địa phương. Cô cũng học thêm về tôn giáo và hiện là người dạy giáo lý ở nhà thờ nơi cô ở tại Willmar. Jan chỉ cho biết đơn giản rằng:\n" +
                    "\n" +
                    "- Tôi là một con người mới và khác biệt, tôi đã chiến thắng nhờ tình yêu bất tận và sự sáng suốt của Thượng Đế.\n" +
                    "\n" +
                    "Sau khi gặp Jan, tôi cũng trở thành một con người mới và khác. Tôi học được cách tạ ơn Thượng Đế vì tất cả mọi điều trong cuộc sống giúp tôi trở nên mới mẻ dù phải vất vả làm thêm một công việc bán thời gian để các con tôi tiếp tục đến trường, học cách làm một bà ngoại tốt lần đầu tiên trong đời, và can đảm chấm dứt với một người bạn tuyệt vời nhưng không hợp với tôi.\n" +
                    "\n" +
                    "Có thể Jan không có tay chân bằng xương bằng thịt, nhưng cô có một trái tim và tâm hồn nóng bỏng hơn bất kỳ người nào tôi từng gặp. Cô đã dạy tôi biết cách nắm giữ mọi điều mới mẻ và khác biệt xuất hiện trong cuộc đời bằng tất cả lòng nhiệt thành - để luôn có cảm giác hân hoan của người chiến thắng.',4,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mái nhà chở che','Nếu ngôi nhà bạn bị cháy, hãy tự sưởi ấm mình bằng ngọn lửa ấy.\n" +
                    "\n" +
                    "Ngạn ngữ Tây Ban Nha\n" +
                    "\n" +
                    "Tôi thật sượng sùng khi bước vào năm đầu tiên ở trường trung học. Rời trường cấp II với cương vị lớp trưởng và tư cách đàn chị, bây giờ thật lạ lẫm khi phải bắt đầu ở vị trí tân binh. Đã thế, mấy đứa bạn thân của tôi đều học ở các trường khác rồi, chỉ còn mình tôi bơ vơ.\n" +
                    "\n" +
                    "Mỗi khi về thăm thầy cô cũ, tôi thường được khuyên nên tham gia những hoạt động đội nhóm để có dịp gặp gỡ bạn mới, rồi thế nào tôi cũng yêu thích trường mới. Lời khuyên của họ đã an ủi tôi phần nào.\n" +
                    "\n" +
                    "Một chiều chủ nhật, gió thu lạnh lẽo rít từng cơn, tôi đang ngồi làm bài tập bên bàn. Mẹ chất thêm củi vào lò sưỏi cho nhà thêm ấm áp. Con mèo lông đỏ nằm trên đống sách vở, kêu gừ gừ, thỉnh thoảng khều khều cây viết cho vui. Nó vốn hay quấn quýt tôi lắm - chẳng gì tôi cũng đã cứu sống nó hồi nó còn bé xíu mà.\n" +
                    "\n" +
                    "Đột nhiên, tôi ngửi thấy mùi gì là lạ, và chợt thấy... khói luồn qua rui nhà. Nó lan nhanh đến nỗi tôi mờ cả mắt. Lật đật tìm cửa, chúng tôi vừa chạy thoát ra sân trước thì toàn bộ mái nhà đã nằm gọn trong biển lửa. Tôi chạy bổ đến nhà hàng xóm gọi cứu hỏa, còn mẹ lại lộn ngược trở vào nhà.\n" +
                    "\n" +
                    "Rồi mẹ bươn ra ngay, mang theo chiếc hộp kim loại đựng các giấy tờ quan trọng. Mẹ đặt cái hộp xuống bãi cỏ, và trong tình trạng gần như phát cuồng, mẹ lại đâm trở vào nhà. Tôi biết mẹ nhất định không để hình ảnh và thư từ của ba bị lửa thiêu rụi. Chúng là những thứ duy nhất mẹ giữ để nhớ về ba. Tuy vậy, tôi vẫn gào:\n" +
                    "\n" +
                    "- Mẹ! Đừng!\n" +
                    "\n" +
                    "Tôi định lao theo mẹ thì bị một bàn tay to lớn giữ lại. Cố thoát ra khỏi bàn tay gọng kềm của người lính cứu hỏa, tôi thét vang:\n" +
                    "\n" +
                    "- Mẹ cháu ở trong đó mà!\n" +
                    "\n" +
                    "- Sẽ ổn thôi, họ sẽ đưa mẹ cháu ra - Chú trấn an tôi.\n" +
                    "\n" +
                    "Chú ấy choàng cho tôi một tấm mền và ấn tôi ngồi vào xe, trong khi đồng đội của chú lao vào nhà chữa cháy. Không lâu sau, một chú lính khác dìu mẹ tôi ra. Chú hối hả đưa mẹ vào xe và chụp mặt nạ ôxy lên mặt mẹ. Tôi lao tới ôm chặt lấy mẹ, lo sợ phải mất bà.\n" +
                    "\n" +
                    "Năm tiếng đồng hồ sau, ngọn lửa được dập tắt. Cả ngôi nhà đã ra tro. Định thần lại, tôi choáng váng khi không thấy con mèo của mình đâu! Trong cơn hoảng loạn, tôi đã quên mất nó. Bao nhiêu chuyện cùng ập đến một lúc - trường mới, ngọn lửa, con mèo - tôi sụp xuống, khóc rấm rứt.\n" +
                    "\n" +
                    "Tối đó chúng tôi không được phép vào nhà vì quá nguy hiểm, mà phải sang nhà ông bà ngủ qua đêm. Tôi thẫn thờ lo cuống lên cho con mèo, dù cả nhà ai nấy chỉ còn mỗi bộ đồ đang mặc trên người và mấy cái mền của đội chữa cháy.\n" +
                    "\n" +
                    "Sáng thứ hai, tôi đến trường với bộ đồ duy nhất còn lại và mang đôi giày của dì. Ước gì mình được nghỉ học. Tại sao mẹ không chịu hiểu rằng tôi đang bối rối lắm? Quần áo thì khác biệt, không có sách vở hay cặp táp gì (cả cuộc sống của tôi đựng trong cái cặp táp đó!). Phải chăng định mệnh buộc tôi phải trở thành người vô gia cư mãi mãi? Có thể lắm. Tôi chỉ muốn thu mình lại hay chết quách đi cho rồi.\n" +
                    "\n" +
                    "Tôi tới trường như một cái xác không hồn. Mọi thứ đều trở nên mờ ảo. Tất cả cuộc sống êm ấm của tôi - trường cũ, bạn bè, nhà cửa và con mèo - đều đã mất sạch.\n" +
                    "\n" +
                    "Sau buổi học, khi đi ngang qua chỗ từng là ngôi nhà của mình, tôi sững người vì những thiệt hại bày ra trước mắt. Ngọn lửa đã nuốt trọn mọi thứ. Chúng tôi chỉ còn giữ lại được những cuốn album, giấy tờ và một số đồ cá nhân mà mẹ tôi đã liều mình cứu ra. Con mèo yêu quý của tôi cũng mất dạng. Trái tim tôi đau nhói.\n" +
                    "\n" +
                    "Chúng tôi phải thuê chỗ ở mới. Không còn thẻ tín dụng hay bất cứ giấy tờ nào để có thể rút tiền ngân hàng nên phải mượn tiền ông bà. Rồi người ta cũng dọn dẹp đống gạch vụn đi. Nhưng tôi vẫn hay thơ thẩn tạt qua nhà cũ, hy vọng sẽ tìm thấy con mèo ở đâu đó. Tôi nhớ nó khủng khiếp, nhớ những khi nó đi theo chọc phá và leo lên váy mình.\n" +
                    "\n" +
                    "Rồi đột nhiên, mọi người trong trường trung học, kể cả thầy cô, đều biết cảnh ngộ của tôi. Tôi lúng túng như thể mình phải chịu trách nhiệm cho tai họa vậy. Cách khởi đầu để nổi tiếng ở trường mới là thế này ư! Quả tình đấy đâu phải là cách để được mọi người quan tâm mà tôi mong muốn. Những người trước đây chưa bao giờ nói chuyện với tôi nay xúm lại và hỏi han dồn dập. Điều này mà xảy ra trước vụ hỏa hoạn thì ắt hẳn tôi kinh ngạc lắm. Hình như độ rày tôi chai cứng rồi. Ây thế mà, tôi chẳng thể dửng dưng trước cái bàn dài chất đầy quà dành cho mình ở trong phòng thể dục. Nào là những đồ dùng học tập, sách vở, nào là quần áo đủ loại - đồ jeans, đồ đẹp có cả. Cứ như là Giáng Sinh vậy! Thật cảm động vô cùng. Trong thoáng chốc, tôi thở phào khoan khoái và nghĩ mọi chuyện rồi sẽ ổn thôi. Ngày hôm đó tôi bắt đầu kết bạn mới.\n" +
                    "\n" +
                    "Một tháng sau, tôi trở lại khu nhà cũ, nơi người ta đang xây dựng lại. Lần này tôi đi với hai người bạn mới. Không còn cảm giác bất an nữa. Âm lòng biết bao khi mở lòng ra với những người tuyệt vời quanh mình. Ngắm ngôi nhà đang dần định hình, mường tượng ra phòng ngủ mới, tôi nhận ra mình sắp thoát khỏi tai ương.\n" +
                    "\n" +
                    "Thình lình, bỗng tôi nghe ai đó hỏi từ sau lưng:\n" +
                    "\n" +
                    "- Có phải con mèo này của cháu không?\n" +
                    "\n" +
                    "Quay lại, tôi không tin vào mắt mình: một người phụ nữ đang bồng con mèo của tôi! Chẳng để lỡ một phút nào, tôi vội nhào tới đón lấy con mèo từ tay bà. Tôi ôm chặt nó vào lòng mà nước mắt rơi lã chã xuống bộ lông màu đỏ tuyệt đẹp của nó. Chú ta gừ gừ sung sương. Các bạn chạy đến ôm lấy tôi, cùng nhảy múa vòng quanh.\n" +
                    "\n" +
                    "Hóa ra con mèo đã hoảng sợ khi thấy ngọn lửa đến nỗi bỏ chạy xa cả dặm. Vòng đeo cổ nó có số điện thoại nhà tôi nhưng điện thoại đã bị cháy và đứt liên lạc. Người phụ nữ tốt bụng này đã giữ nó và khó khăn lắm mới tìm ra tôi. Chẳng hiểu sao bà lại biết chắc hẳn con mèo này được yêu và được nhớ nhiều như thế.\n" +
                    "\n" +
                    "Ngồi giữa bạn bè, với con mèo cuộn tròn trên váy, những cảm giác về mất mát và tai họa dường như nhỏ lại. Tôi cảm thấy biết ơn cuộc đời, bạn bè mới, lòng tốt của những người lạ mặt. Con mèo đã trở về. Và tôi cũng vậy.',5,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bước ngoặt cuộc đời','Chúng ta thường không đón nhận sự việc theo như tính chất của chúng: trái lại, chúng ta có khuynh hướng cảm nhận mọi biến cố theo cách thức chúng ta sống và suy nghĩ.\n" +
                    "\n" +
                    "- Anais Nin\n" +
                    "\n" +
                    "Tôi bắt đầu hiểu biết về hội chứng tự kỷ vào những năm 1940. Là con út trong nhà nên từ lúc mới bốn tuổi tôi đã biết anh Scott là một bí mật đau buồn của gia đình. Cả nhà bối rối đến mức luôn giấu biệt anh vào phòng ngủ mỗi khi có khách đến chơi.\n" +
                    "\n" +
                    "Căn bệnh cùng nỗi đau mà anh Scott đang chịu đựng quá đỗi riêng tư để có thể chia sẻ với người khác. Tôi và các chị đã tìm mọi cách để rời khỏi gia đình càng nhanh càng tốt - kết hôn sớm hoặc vào đại học ở thành phố khác. Nhiều năm sau, có lần tôi nghe một nhà tâm lý học gọi hành động đó là “Trốn chạy ruột thịt”. Quả đúng vậy, nhưng không phải anh Scott đã “đuổi” chúng tôi đi, mà chính là nỗi sợ hãi lẫn xấu hổ đã khiến chị em tôi không thể ở nhà nổi.\n" +
                    "\n" +
                    "Ban đầu, thấy cha mẹ khốn đốn vì anh Scott, tôi nguyện sẽ không bao giờ có con, để đừng bao giờ phải làm cha một “đứa trẻ không bao giờ trưởng thành”.\n" +
                    "\n" +
                    "Nỗi sợ đeo đuổi tôi tới tận lúc tôi lập gia đình được 5 năm. Đứng trước nguy cơ mất đi người phụ nữ mình yêu, tôi quyết định có đứa con đầu lòng.\n" +
                    "\n" +
                    "Ted có khởi đầu hoàn hảo, mọi xét nghiệm đều cho thấy bé không mắc phải khuyết tật bẩm sinh nào. Dù phải sinh mổ nhưng bé cũng được chín trên thang điểm mười theo bản đánh giá tình trạng trẻ sơ sinh - một nhà vô địch của phòng sinh!\n" +
                    "\n" +
                    "Cho đến sinh nhật lần thứ hai, mỗi cử động và lời nói của Ted đều biểu hiện sự tinh khôn và sáng dạ! Nhưng rồi chúng tôi nhận thấy thằng bé hơi khang khác. Lời nói thì lạ lùng (có thể nó không cần đặt câu hỏi); Ted không chơi với bạn cùng tuổi (có lẽ nó thích người lớn hơn); chỉ số phát triển trên đồ thị bắt đầu đi xuống (có lẽ đồ thị này sai) - tôi luôn tìm cách tự biện hộ như thế.\n" +
                    "\n" +
                    "Khi Ted tròn ba tuổi, một loạt những chẩn đoán kết luận: “tổn thương não”, “khiếm khuyết hệ thần kinh” và cuối cùng là “hội chứng tự kỷ”. Dù cố gắng đưa con tìm thầy thuốc chữa chạy khắp nơi, nhưng càng hiểu biết về căn bệnh này chúng tôi càng ít hy vọng. Dường như cơn ác mộng của tôi ngày xưa giờ đã thành hiện thực. Tuy nhiên, nếu nhìn ở hướng tích cực thì vợ chồng tôi có những thế mạnh mà cha mẹ tôi không có - nghề nghiệp ổn định và học vấn tốt. Hơn nữa, xã hội đang dần công nhận quyền và nhu cầu của người khuyết tật. Không như thời anh Scott bị giữ ở nhà suốt, vào thập niên 1970 con trai tôi được luật pháp bảo đảm được hưởng chế độ giáo dục thích hợp. Y học cũng đã tiến bộ hơn. Giờ đây, khuyết tật của trẻ không còn bị cho là lỗi của cha mẹ nữa.\n" +
                    "\n" +
                    "Nhớ lại quá khứ, tôi nhận ra rằng gia đình mình khi xưa đã sai lầm trong cách cư xử với anh Scott: anh không phải là “nỗi phiền muộn” của chúng tôi mà ngược lại - chúng tôi là “nỗi phiền muộn” của anh! Tôi thừa nhận sự thật lúc nào cũng đau đớn, nhưng nỗi đau sẽ mang lại cho ta lòng quyết tâm và động lực vượt qua thử thách. Đột nhiên tôi nghiệm ra một điều: sự việc xảy đến với ta có thể bị coi là một tai họa mà cũng có thể là một ân phúc - tất cả đều tùy thuộc vào cách ta nhìn nhận nó như thế nào.\n" +
                    "\n" +
                    "Những triệu chứng bệnh tật của Ted ngày càng lộ rõ. Vợ chồng tôi hợp sức cố gắng thông hiểu Ted, đồng thời quyết định không bao giờ che đậy hay mắc cỡ vì cháu. Khi đứa con thứ hai ra đời, cảm xúc và suy nghĩ của cháu ở cương vị của một người có anh trai không được bình thường đều được tôi lưu tâm với tất cả sự thông cảm sâu sắc. Cả hai đứa con tôi đều được ăn học tử tế, dù với Ted mọi việc có vất vả hơn gấp nhiều lần.\n" +
                    "\n" +
                    "Đến sinh nhật lần thứ 22 của Ted, chúng tôi nhận thấy mình đã chuẩn bị đầy đủ cho con bước vào thế giới người lớn. Cuối năm Ted sẽ tốt nghiệp. Cháu sẽ có một nguồn thu nhập tương đối từ các công việc bán thời gian và sự trợ giúp của chính phủ. Chúng tôi còn sửa sang lại tầng trệt của căn hộ cho Ted. Nhưng dường như cháu vẫn chưa hài lòng lắm. Mùa xuân năm đó, Ted thông báo:\n" +
                    "\n" +
                    "- Con sẽ tham dự đêm khiêu vũ toàn trường.\n" +
                    "\n" +
                    "Chuyện phức tạp ở chỗ Ted khó có thể tự mình mời một cô gái nào đi cùng. Từ hồi 18 tuổi, trong khi bạn bè đều đã có đôi thì các cô gái lại gọi cháu là “em cưng” và chẳng ai chịu hò hẹn với cháu. Tuy thế, cuối cùng Ted cũng đã có được bạn nhảy - Jennifer, một cô gái dễ thương tóc vàng, con một người bạn của gia đình. Cô bé đã gặp gỡ và tỏ ra mến Ted, đồng thời cũng hiểu được buổi dạ vũ này có ý nghĩa như thế nào đối với cháu.\n" +
                    "\n" +
                    "Chúng tôi giúp Ted chuẩn bị cho buổi tối trọng đại này. Vợ tôi hấp tẩy bộ dạ phục cho Ted còn tôi tình nguyện làm tài xế cho hai cô cậu. Ted còn lên kế hoạch đi ăn tối với Jennifer trước khi đến trường. Và thậm chí cả hoa để tặng cho Jennifer nữa.\n" +
                    "\n" +
                    "Chỉ cần hai phút là tôi có thể đặt mua hoa cho con, nhưng tôi muốn Ted tự làm lấy. Tôi đau đớn tự hỏi không biết con trai mình còn có cơ hội nào khác để tặng hoa cho một phụ nữ nào nữa không. Trước khi đến cửa tiệm, chúng tôi đã tập đi tập lại cho Ted cách nói với người bán hoa. Tôi đóng vai người bán hoa, mời Ted vào “cửa hàng ảo” của tôi. Sau đó, chúng tôi bước sang tiệm bán hoa gần nhà.\n" +
                    "\n" +
                    "Thấy có người đến, cô bán hoa ngưng việc cắt tỉa và chú ý đến chúng tôi. Tôi nhìn Ted và chờ đợi con mình lên tiếng. Cả cửa hàng trở nên im ắng lạ thường. Toàn thân Ted cứng đờ. Nhưng rồi khuôn mặt Ted chuyển động và lời nói tuôn ra:\n" +
                    "\n" +
                    "- Tôi là Ted. Tôi đến đây để thuê những bông hoa màu tía.\n" +
                    "\n" +
                    "Cô bán hoa có vẻ giật mình. Cô liếc nhìn tôi khi tôi bình tĩnh nhắc:\n" +
                    "\n" +
                    "- Con hãy cố gắng nói lại lần nữa đi.\n" +
                    "\n" +
                    "Cháu hít thở thật sâu rồi nhíu mày. Tôi khuyến khích Ted bình tĩnh và nói thật chậm. Cuối cùng cháu cũng giải thích được. Một bó hoa hồng đỏ sẽ được giao vào chiều thứ bảy theo ý Ted. Nhưng tôi đã không hề nghĩ đến phản ứng của cô gái bán hoa.\n" +
                    "\n" +
                    "- Ông kiên nhẫn thật đấy! - Người bán hoa trầm trồ thán phục tôi.\n" +
                    "\n" +
                    "Không! Tôi chỉ muốn la lên đó không phải là kiên nhẫn mà là “hiểu rõ vấn đề”. Với chúng ta, mỗi khi nói hệ thần kinh truyền tín hiệu từ ngân hàng dữ liệu trong bộ nhớ đến trung ương thần kinh, rồi lại chuyển tín hiệu đến dây thanh quản và quay lại. Nhưng Ted phải dày công tập luyện những bước nhỏ này, vất vả lội ngược dòng để tìm đến những điều mà những người khác tự nhiên có. Cô bán hoa đã khâm phục nhầm người! Cô đâu biết rằng Ted đã phải vượt qua bao gian khổ, đắng cay và kiên trì như thế nào mới đạt được như thế.\n" +
                    "\n" +
                    "Tối thứ bảy, sau khi đưa Ted và Jennifer đến trường, tôi gọi điện cho chị mình. Hai chị em cùng nhắc lại cuộc đời u ám của anh Scott lẫn những tiến bộ đáng kinh ngạc của Ted. Và, chúng tôi bật khóc.\n" +
                    "\n" +
                    "Sau này, tôi đặt bức ảnh chụp Ted và Jennifer trong đêm dạ vũ tại nơi trang trọng nhất trong nhà. Trên tay Jennifer là bó hoa hồng đỏ thắm.',6,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đừng sợ đối mặt với nỗi sợ hãi','Lòng can đảm giúp chúng ta chống lại nỗi sợ hãi tĩm cách khống chế nó, chứ không phải giúp chúng ta chối bỏ sự tồn tại của nó.\n" +
                    "\n" +
                    "- Mark Twain\n" +
                    "\n" +
                    "“Cuộc đời gần như là hoàn hảo!”, tôi tự nhủ và cám ơn số phận đã rất ưu ái với tôi. Quả thật tôi đã và đang đứng trên đỉnh cao của danh vọng. Hơn một năm qua, tôi là ngôi sao trong một vở nhạc kịch ăn khách của sân khấu Paris trắng lệ. Tôi được giao vai trong bốn vở nhạc kịch của một hãng phim nổi tiếng. Và hơn hết, tôi có rất nhiều bạn tốt, những người tôi vẫn thường xuyên gặp gỡ chuyện trò.\n" +
                    "\n" +
                    "Lúc đó là năm 1922. Tôi đã không hiểu vì sao mà bao nhiêu may mắn lại nhanh chóng từ biệt tôi như vậy.\n" +
                    "\n" +
                    "Sau này, ôn lại những gì đã xảy ra tại rạp Les Bougges Parisiens vào buổi tối hôm ấy, tôi nhận thấy đã có những dấu hiệu cảnh báo trước đó. Trong nhiều tháng trời, tôi đã làm việc quá sức, lại thiếu ngủ thường xuyên. Đôi khi, tôi cảm thấy mình như người kiệt sức - đầu óc nặng trịch, bao hứng khỏi tan biến đi đâu hết cả. Thế mà tôi chẳng hề lưu tâm. “Chắc chỉ mệt mỏi chốc lát thôi”, tôi tự nhủ, rồi lại bước ra sân khấu, tự ép mình diễn thật hay đúng như những gì khán giả mong đợi.\n" +
                    "\n" +
                    "Tuy nhiên, tối hôm ấy sự việc không diễn ra bình thường như mọi tối. Trước đó, vào bữa trưa kéo dài hàng giờ với bạn bè, tôi đã ngu ngốc đắm mình trong rượu ngon và ních thật căng bụng. Tôi tranh thủ chợp mắt vài phút với hy vọng sẽ tỉnh táo lại trước giờ diễn. Thế nhưng khi đến rạp hát, đầu tôi cứ phừng phừng như bốc lửa. Trước đây tôi chưa bao giờ rơi vào tình trạng xây xẩm như thế này. Tôi cố gắng xua tan nó khi chờ nghe gọi đến lớp diễn của mình. Dù vậy khi nghe gọi, những lời này như đến từ một nơi xa xăm nào đó. Tôi bước ra sân khấu, xương lên lời thoại quen thuộc của vai tôi diễn. Nhưng rõ ràng có điều gì đó không ổn. Tôi có thể nhận thấy điều đó qua ánh mắt của người bạn diễn.\n" +
                    "\n" +
                    "Khi tôi hát tiếp đoạn thứ hai, sự ngạc nhiên trong tôi đã chuyển thành lời báo động và tôi kinh hoàng nhận ra rằng mình đã hát nhầm lời của cảnh ba thay vì cảnh một! Tôi cố gắng hết sức lấy lại bình tĩnh nhưng vô vọng. Đầu tôi lúc ấy đột nhiên rối tung. Tôi như kẻ mất hồn.\n" +
                    "\n" +
                    "Người bạn diễn hát đỡ lời tôi một cách khéo léo, anh ấy thầm thì nhắc tôi những chữ đầu của mỗi đoạn tôi phải hát và cứ thế, những người khác cũng lần lượt nhắc tôi trong những cảnh sau. Buổi diễn tối hôm đó đã kết thúc mà chỉ những người ở sau cánh gà mới biết chuyện gì đã xảy ra.\n" +
                    "\n" +
                    "Sau buổi diễn, các bạn đồng nghiệp cười xòa và an ủi tôi rằng đó chỉ là sự bất ổn nhất thời. Tôi cũng muốn tin như vậy, nhưng tôi đã thật sự hoảng loạn. Điều gì sẽ đến nếu sự cố tối nay chỉ là một sự mở đầu? Một diễn viên kịch không nhớ nổi lời thoại của mình - điều này có nghĩa là sự nghiệp tiêu tan. Một dấu chấm hết cho một nghề nghiệp đã đưa tôi thoát khỏi những quán café tồi tàn ở Montmartre - nơi tôi đã phải hát để kiếm sống qua ngày - để đến những rạp hát sang trọng nhất của Paris trắng lệ kèm với tiền thù lao hàng ngàn đô-la mỗi tuần.\n" +
                    "\n" +
                    "Ngày hôm sau, tôi đọc đi đọc lại lời thoại của mình, ôn lại từng câu ca, lời hát mà tôi đã thuộc làu cả năm qua. Nhưng đến tối, nỗi kinh hoàng quay trở lại và đi kèm theo nó là cơn ác mộng đeo đẳng tôi nhiều tháng liền. Đứng trên sân khấu, tôi thấy mình không tài nào tập trung được vào lời thoại phải nói lúc ấy mà đầu óc cứ mải chạy theo những lời thoại của một vài cảnh sắp tới và cố gắng chuẩn bị để nói những lời này. Tôi hết ngập ngừng thì lại nói lắp bắp. Sự thoải mái, tự nhiên đã giúp tôi trở thành diễn viên danh tiếng chạy đi đâu mất. Rồi tôi thấy xây xẩm mặt mày, sàn diễn và mọi vật như quay vòng trước mắt tôi. Tôi thực sự sợ hãi nghĩ đến cảnh mình ngã gục ngay trên sàn diễn.\n" +
                    "\n" +
                    "Tôi đi khám hết bác sĩ này đến chuyên gia khác. “Suy nhược thần kinh”, họ nói rồi chích thuốc, dùng điện từ xoa bóp cho tôi, bắt tôi theo chế độ ăn kiêng đặc biệt. Nhưng tất cả đều vô hiệu. Người ta bắt đầu bàn tán xôn xao rằng sự nghiệp diễn viên của tôi đang trượt dốc. Tôi cố tránh gặp bạn bè vì tôi chắc họ cũng đã biết tình trạng bất ổn của tôi.\n" +
                    "\n" +
                    "Nhưng khi tình trạng đầu óc choáng váng xảy ra thường xuyên hơn, tôi biết rõ ràng sự suy sụp thần kinh là không thể tránh khỏi. Và nó đã đến thật. Lúc đó, mọi thứ với tôi thế là hết. Cả thế giới trước mắt tôi sụp đổ tan tành.\n" +
                    "\n" +
                    "Bác sĩ yêu cầu tôi đi nghỉ tại một khu điều dưỡng ở Saujon, một ngôi làng nhỏ bé ở miền tây nam nước Pháp. “Thế giới của Maurice Chevalier đã vỡ vụn”, tôi thở dài, “và chẳng còn nơi nào có thể hàn gắn lại những mảnh vỡ ấy nữa”.\n" +
                    "\n" +
                    "Tuy nhiên, lúc đó tôi đã không thể ngờ đến sự tinh tường và lòng nhẫn nại của vị bác sĩ già tài giỏi tại Saujon. Đọc xong hồ sơ bệnh án của tôi, bác sĩ Robert Dubơis vạch ra một phương án điều trị đơn giản chỉ bằng nghỉ ngoi và thư giãn.\n" +
                    "\n" +
                    "- Sẽ chẳng ăn thua gì đâu, - tôi uể oải nói, - tôi hết thời rồi.\n" +
                    "\n" +
                    "Nhưng rồi trong nhiều tuần sau đó, theo lời bác sĩ, tôi thả bộ một mình dọc theo những con đường làng do ông vạch ra. Và dần dần tôi tìm thấy những nét yên bình trong vẻ đẹp của thiên nhiên; sự yên bình vẫn luôn tồn tại trong tôi mà tôi đã quên bẵng đi. Rồi cũng đến một ngày, bác sĩ Dubơis khẳng định với tôi rằng thần kinh của tôi đã bình phục hoàn toàn. Tôi rất muốn tin ông nhưng trong lòng còn ngờ vực. Giờ đây sự hoảng loạn trong tôi không còn nữa nhưng tôi vẫn thấy mình chưa đủ tự tin.\n" +
                    "\n" +
                    "Một buổi chiều, bác sĩ Dubơis đề nghị tôi trình diễn giúp vui cho một nhóm người nhân ngày hội làng. Cứ nghĩ đến chuyện phải đối mặt với khán giả - bất cứ khán giả nào - là tôi thấy đầu óc mình trở nên mụ mẫm. Tôi vội vàng từ chối lời đề nghị đó.\n" +
                    "\n" +
                    "- Tôi biết cô có thể làm được, Maurice, - bác sĩ nói, - và cô phải chứng tỏ điều này cho chính bản thân cô. Đây là cơ hội tốt để cô khởi đầu đấy!\n" +
                    "\n" +
                    "Tôi thấy thật kinh hãi.\n" +
                    "\n" +
                    "- Có gì bảo đảm là tâm trí tôi sẽ không rối tung lên như trước?\n" +
                    "\n" +
                    "- Chẳng có điều gì bảo đảm cho cô cả. - Bác sĩ Dubơis chậm rãi nói, và ông tiếp tục với một câu nói mà đến hôm nay tôi vẫn nghe thấy văng vẳng bên tai mình như ba mươi năm trước - Đừng sợ phải đối mặt với nỗi sợ hãi!\n" +
                    "\n" +
                    "Mãi đến khi ông giải thích, tôi mới hiểu hết ý câu nói đó của ông.\n" +
                    "\n" +
                    "- Cô sợ lại phải bước lên sân khấu, do đó cô tự nói với mình thế là hết. Nhưng sợ hãi không bao giờ là nguyên nhân rời bỏ sàn diễn của cô cả; nó chỉ là một cái cớ mà thôi. Khi một người dũng cảm gặp phải nỗi sợ hãi, anh ta thừa nhận sự tồn tại của nó - và rồi vững bước vượt qua mà không còn lưu tâm đến nó nữa.\n" +
                    "\n" +
                    "Ông dừng lại ở đó và đợi câu trả lời của tôi. Mãi một lúc lâu sau, tôi mới cất tiếng.\n" +
                    "\n" +
                    "- Tôi sẽ thử xem!\n" +
                    "\n" +
                    "Tôi quay về phòng mà tim đập loạn xạ khi nghĩ đến những gì đang chờ đón tôi phía trước. Trong những ngày kế tiếp, tôi trải qua những giờ phút căng thẳng hồi hộp khi cứ nhai đi nhai lại lời bài hát mà tôi sẽ trình diễn. Rồi thử thách cuối cùng đã đến - tôi đứng sau cánh gà của một sân khấu nhỏ đợi đến lượt mình ra diễn.\n" +
                    "\n" +
                    "Ngay tức thời, nỗi sợ hãi lại vây lấy tôi, bất giác tôi muốn quay lưng và bỏ chạy thật nhanh. Nhưng từng lời nói của vị bác sĩ cứ vọng mãi bên tai tôi: “Đừng sợ phải đối mặt với nỗi sợ hãi!”. Và đúng lúc đó, dàn nhạc nghiệp dư của làng trỗi nhạc ra hiệu đã đến phần biểu diễn của tôi. Tôi bước ra sân khấu và bắt đầu cất tiếng hát.\n" +
                    "\n" +
                    "Mỗi một lời tôi hát, mỗi một câu tôi ca tối hôm đó là cả một sự cố gắng đến khổ sở. Nhưng lần này, trí nhớ đã không chơi khăm tôi nữa. Khi bước xuống khỏi sân khấu trong tiếng vỗ tay nồng nhiệt, tôi cảm thấy niềm vui chiến thắng nâng bổng mình lên. Tối hôm đó, tôi đã không át đi được nỗi sợ hãi; đơn giản, tôi chỉ thừa nhận sự có mặt của nó và rồi tiếp tục công việc của mình mà không lưu tâm đến nó nữa. Biện pháp đó thật hữu hiệu.\n" +
                    "\n" +
                    "Rốt cuộc tôi đã nhìn thấy con đường giúp tôi quay lại với sự nghiệp của mình. Tôi tự nhủ, có thể tôi sẽ chẳng bao giờ lấy lại sự tự tin mà mình hằng có, bởi điều gì đã xảy ra một lần bất cứ lúc nào cũng có thể xảy ra lần nữa. Nhưng giờ đây tôi có thể sống cùng với nó, và tôi quyết tâm chứng tỏ mình sống chung được với nó.\n" +
                    "\n" +
                    "Con đường quay lại Paris thật không dễ dàng chút nào. Tôi chọn Melum, một thành phố nhỏ cách thủ đô vài dặm làm nơi khỏi nghiệp trở lại. Tôi đến một rạp hát nhỏ và xin gặp người chủ rạp. Ông ta giật mình và ngạc nhiên nhìn tôi, và khi tôi đề nghị được hát với một số tiền thù lao nhỏ nhoi, ông nghĩ rằng tôi đang đùa. Nhưng tôi thuyết phục rằng tôi muốn nhờ ông giúp tôi trở lại sàn diễn, ông mới gật đầu ưng thuận. Và cứ theo cách này, tôi lại bắt đầu những buổi biểu diễn của mình hết thành phố này đến thành phố khác. Mỗi buổi biểu diễn là một cuộc đấu tranh đau đớn và khổ sở trong tâm trí tôi.\n" +
                    "\n" +
                    "“Vậy là mình vẫn còn sợ à?”, cứ mỗi lần như thế tôi lại thì thầm với mình, “Thế thì đã sao?”.\n" +
                    "\n" +
                    "Cuối cùng, tôi tiếp tục lẩm bẩm những lời này khi đứng chờ lớp diễn của mình tại một hí viện lộng lẫy, mới xây dimg ở Paris, sẵn sàng đối mặt với khán giả thủ đô. Tối hôm ấy khi màn sân khấu hạ xuống cũng là lúc một chân trời mới mở ra trước mắt tôi. Tôi cúi chào liên tục trong tiếng vỗ tay vang dội cả hí viện rộng lớn. Thành công, sự thành công mà tôi đã từng có và từng mất, giờ đây đã quay trở lại với tôi.\n" +
                    "\n" +
                    "Từ buổi tối hôm ấy và cho đến mãi bốn thập ký sau đó, tôi đã tiếp tục công việc mà tôi yêu thích - mang tiếng hát đến cho khán giả ở khắp đất nước. Trong suốt thời gian đó, tôi cũng đã trải qua nhiều khoảnh khắc sợ hãi, và đúng như lời người bác sĩ già tài ba ở Saujon đã nói: “Chẳng có điều gì bảo đảm cho cô cả”. Nhưng cảm giác đe dọa đó không bao giờ còn có thể khiến tôi từ bỏ sự nghiệp ca hát nữa.\n" +
                    "\n" +
                    "Đã bao lần trên đường đời, chúng ta đã để nỗi sợ hãi biến thành chướng ngại vật ngăn trở bước tiến của mình? Chúng ta thấy được điều mình mong muốn đang ở phía trước, nhưng thay vì thừa nhận nỗi lo sợ vẫn hiện hữu trong lòng nhưng chúng ta vẫn sẵn sàng tiến bước, chúng ta lại luôn viện mọi lý do để rồi cuối cùng ngán ngại và quay lùi cam chịu thất bại.\n" +
                    "\n" +
                    "Chính kinh nghiệm bản thân đã dạy tôi rằng: Nếu chúng ta cứ mong đợi một khoảnh khắc tuyệt hảo, khi mà mọi chuyện được bảo đảm tuyệt đối an toàn và chắc chắn, thì giây phút đó sẽ không bao giờ tới. Và khi đó, những ngọn núi cao sẽ không còn ai chinh phục, những cuộc tranh đua không có người chiến thắng và hạnh phúc vĩnh cửu sẽ chẳng đến với ai.',7,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tấm huy chương vàng','Bạn nhận được sức mạnh, lòng can đảm và sự tự tin từ bất kỳ trải nghiệm nào khiến bạn đau khổ và sợ hãi. Bạn có thể tự nhủ rằng: “Tôi đã vượt qua. Giờ đây, tôi sẵn sàng đón nhận những điều kế tiếp”.\n" +
                    "\n" +
                    "- Eleanor Roosevelt\n" +
                    "\n" +
                    "Có một lần vào mùa xuân năm 1995, tôi đã được mời phát biểu tại một trường phổ thông trung học. Khi buổi lễ kết thúc, ông hiệu trưởng ngỏ ý mời tôi đến thăm một học sinh đặc biệt. Cậu bé bị bệnh phải nằm liệt giường, nhưng cậu ấy rất muốn được gặp tôi. Ông hiệu trưởng bảo rằng điều đó sẽ có ý nghĩa lớn lao đối với cậu ấy. Tôi đã đồng ý.\n" +
                    "\n" +
                    "Trong quãng thời gian lái xe chín dặm đường đến nhà Matthew, tên cậu học sinh ấy, tôi đã biết được đôi điều về cậu. Cậu bị mắc bệnh teo cơ. Khi mới chào đời, các bác sĩ đã cho cha mẹ cậu biết rằng cậu sẽ không sống được đến 5 tuổi, sau đó họ lại bảo cậu chẳng được dự sinh nhật thứ mười. Giờ cậu bé đã 13 tuổi, và theo những gì tôi được nghe kể thì cậu quả là một người dũng cảm thật sự. Cậu bé muốn gặp tôi vì tôi là một lực sĩ cử tạ đạt huy chương vàng, tôi biết cách vượt qua những chướng ngại khó khăn, điều mà bao người mơ ước.\n" +
                    "\n" +
                    "Tôi đã trò chuyện với Matthew hơn một tiếng đồng hồ. Chưa một lần nào cậu than thở về cảnh ngộ của mình. Cậu toàn nói về chiến thắng, sự thành công và việc thực hiện những giấc mơ của mình. Cậu không đề cập gì đến việc các bạn cùng lớp đã chế giễu cậu vì sự khác biệt của cậu; cậu chỉ nói về những hy vọng trong tương lai và mong rằng một ngày nào đó cậu muốn cử tạ cùng với tôi.\n" +
                    "\n" +
                    "Khi chia tay cậu bé, tôi lấy trong cặp của mình chiếc huy chương vàng đầu tiên mà tôi đã giành được trong môn cử tạ rồi đeo vào cổ cậu bé. Tôi bảo cậu rằng cậu còn hơn cả một người chiến thắng và cậu hiểu về sự thành công cũng như biết cách vượt qua mọi trở ngại còn hơn cả tôi nữa. Cậu bé nhìn chiếc huy chương một lúc rồi trao lại cho tôi. Cậu nói:\n" +
                    "\n" +
                    "- Rick ạ, anh là nhà vô địch. Anh đã giành được chiếc huy chương này. Một ngày nào đó, khi em tham dự Thế vận hội và giành huy chương vàng của em, em sẽ cho anh xem.\n" +
                    "\n" +
                    "Mùa hè năm ngoái tôi nhận được thư của cha mẹ Matthew. Họ báo tin Matthew đã qua đời. Họ muốn tôi đọc lá thư mà cậu bé đã viết cho tôi cách đó vài ngày:\n" +
                    "\n" +
                    "“Rick thân yêu!\n" +
                    "\n" +
                    "Mẹ bảo em nên viết thư cám ơn anh về bức tranh tinh tế mà anh đã gởi cho em. Em cũng muốn báo cho anh biết các bác sĩ bảo em chẳng còn sống được bao lâu nữa. Càng ngày em càng thấy khó thở và rất dễ mệt, nhưng em vẫn cố hết sức để mỉm cười. Em biết mình sẽ không bao giờ khỏe mạnh được như anh và chúng ta sẽ không bao giờ có thể cùng nhau nâng những quả tạ nữa.\n" +
                    "\n" +
                    "Em mong muốn một ngày nào đó mình sẽ tham dự Thế vận hội và sẽ giành một chiếc huy chương vàng. Giờ thì em biết mình sẽ không bao giờ đạt được điều đó. Nhưng em biết em là một nhà vô địch, và có lẽ Thượng Đế cũng biết điều đó. Người biết em không phải là một kẻ chịu đầu hàng, và khi em lên Thiên đàng, Người sẽ trao cho em chiếc huy chương vàng của em. Khi nào anh đến đây, em sẽ cho anh xem nó.\n" +
                    "\n" +
                    "Cám ơn vì tình Cảm ơn đã dành cho em.\n" +
                    "\n" +
                    "Người em, người bạn của anh,\n" +
                    "\n" +
                    "Matthew”',8,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Sức sống mãnh liệt','Sự yếu đuối trong tính cách mới là khuyết điểm duy nhất không thể thay đổi.\n" +
                    "\n" +
                    "- Francois de La Rochefoucald\n" +
                    "\n" +
                    "Lần đầu tiên tôi thấy con Khói là khi nó đang ở trong đống lửa! Một lần cùng ba đứa con nhỏ của mình đến bãi rác nằm ngoài thị trấn để đốt rác như thường lệ, tôi phát hiện nó bị vùi trong một đống gạch đang cháy âm ỉ. Khi ấy, nó là một chú mèo nhỏ xíu, toàn thân năm đen như than đang cố hết sức bình sinh bò về phía chúng tôi.\n" +
                    "\n" +
                    "- Con sẽ cứu nó! - Thằng bé Scott con tôi la lên.\n" +
                    "\n" +
                    "Khi Scott bước tới bọc con mèo cẩn thận trong chiếc khăn rằn của tôi, tôi tự hỏi tại sao con mèo không kêu la khi bị chạm đến những chỗ đau như vậy. Sau này, chúng tôi mới phát hiện lưõi của nó cũng bị bỏng nặng.\n" +
                    "\n" +
                    "Chúng tôi mang con mèo về nông trại. Trong lúc bốn mẹ con đang chăm sóc cho nó thì chồng tôi, Jim, trở về nhà sau một ngày dài sửa hàng rào mệt lử. Anh chẳng ngạc nhiên gì khi trông thấy nó, vì đây không phải là lần đầu tiên chúng tôi đón chào Jim về nhà bằng một con thú bị thương. Dù ngoài miệng lúc nào cũng càu nhàu bực bội nhưng trong lòng Jim cũng không nỡ nhìn thấy chúng đau đớn. Vì thế, anh thường giúp chúng tôi làm chuồng, lo chỗ nằm, làm rào và thanh nẹp chân cho những con chồn, thỏ và mấy chú chim bị thương mà chúng tôi đem về. Tuy nhiên, lần này thì khác. Đây là một con mèo, mà Jim thì chẳng thích mèo tí nào.\n" +
                    "\n" +
                    "Chẳng những thế, con mèo này lại không bình thường. Trên thân thể nó, những chỗ đáng lẽ được phủ lông mượt giờ chỉ toàn là vết bỏng. Đôi tai của nó không còn và chiếc đuôi thì bị cháy đến lộ cả xương. Các dấu chân nhỏ bé có thể vẫn thường in trên mui những chiếc xe hơi hay xe tải đầy bụi thì nay cũng không còn đúng hình dạng của chúng nữa. Nó hầu như chẳng còn có nét gì của một con mèo - ngoài đôi mắt to xanh thẳm cầu xin sự giúp đỡ.\n" +
                    "\n" +
                    "Thế là chúng tôi chữa trị vết thương cho nó cẩn thận. Chúng tôi còn đặt tên cho nó là Khói để ký niệm lần đầu tìm thấy nó.\n" +
                    "\n" +
                    "Sau ba tuần, chúng tôi có thể bôi thuốc mỡ chữa bỏng cho con Khói, khiến toàn thân nó trở thành một khối màu xanh lạ kỳ. Đuôi nó thì đã gãy lìa, và bộ lông mượt mà đầy hãnh diện của loài mèo cũng chẳng còn một sợi nào - nhưng cả tôi lẫn bọn trẻ đều “ngưỡng mộ” nó.\n" +
                    "\n" +
                    "Nhưng Jim lại không như vậy. Thế nên, Khói cũng chẳng quý anh. Tại sao ư? Vì anh có thứ dụng cụ mồi ống điếu gồm diêm quẹt và cái đèn khi đốt cháy bập bùng. Mỗi lần anh đốt chiếc đèn này lên, con Khói lại trở nên hoảng sợ và quáng quàng bỏ chạy - có lần nó còn làm đổ cả tách cà phê và chiếc đèn của anh trước khi chạy biến vào ống thông gió trong căn phòng ngủ dự phòng.\n" +
                    "\n" +
                    "- Tại sao mày chẳng để tao yên tí nào thế này? - Jim rên rỉ.\n" +
                    "\n" +
                    "Tuy vậy càng ngày con Khói càng quen dần với cái ống điếu và chủ nhân của nó hơn. Nó nằm trên chiếc tràng ký và nhìn trừng trừng vào Jim khi anh hút ống điếu và phà khói thuốc ra. Một hôm, Jim nhìn tôi cười khúc khích.\n" +
                    "\n" +
                    "- Cái con mèo chết tiệt này, nó làm anh thấy tội lỗi quá!\n" +
                    "\n" +
                    "Cuối năm đầu tiên, con Khói trông vẫn còn thảm hại, chẳng khác cái giẻ rách là mấy. Còn thằng Scott nhà tôi lại trở nên nổi tiếng trong đám bạn vì có một con mèo xấu nhất nước - mà cũng có thể là xấu nhất trần đời.\n" +
                    "\n" +
                    "Dần dần và cũng hết sức lạ lùng, Jim trở thành người mà con Khói quan tâm nhất. Và chẳng lâu sau, tôi nhận thấy một sự thay đổi ở Jim. Giờ đây, ít khi anh hút thuốc trong nhà, và vào một tối mùa đông nọ, tôi hết sức ngạc nhiên khi thấy anh ngồi trên ghế với con mèo nhỏ xấu xí đang nằm cuộn trong lòng anh. Trước khi tôi kịp lên tiếng thì anh đã lầm bầm, nói cộc lốc như để phần trần.\n" +
                    "\n" +
                    "- Em biết không, có lẽ nó lạnh, nó không có lông mà.\n" +
                    "\n" +
                    "Nhưng, tôi nhớ lại, cái con Khói này thích cái lạnh lắm mà! Chẳng phải nó đã ngủ ngay trước ống thông gió và trên sàn lót ván lạnh ngắt đấy ư?\n" +
                    "\n" +
                    "Có lẽ Jim đã bắt đầu thấy thích con vật kỳ dị này rồi!\n" +
                    "\n" +
                    "Không phải ai cũng đều chia sẻ tình cảm mà chúng tôi dành cho Khói, nhất là những ngưòl chưa bao giờ trông thấy nó. Lời đồn đại đến tai một nhóm tự nhận rằng mình là những người bảo vệ thú, và một bữa, một phụ nữ trong nhóm họ đã đến gõ cửa nhà chúng tôi. Họ nghĩ rằng chính chúng tôi đã bạc đãi con Khói. Nhưng khi tận mắt trông thấy dáng vẻ “uy nghi” trần trụi của con Khói được phóng đại gấp 10 lần đang nấp đằng sau bể nuôi cá nhà tôi và đang trừng mắt nhìn vào vị khách thì bà ta đã thay đổi cách nghĩ và nhanh chóng cáo từ.\n" +
                    "\n" +
                    "Sang năm thứ hai, một điều kỳ diệu xảy ra. Lông con Khói bắt đầu mọc lại. Những sợi lông trắng bé xíu, mềm mại và đẹp hơn cả lông của các chú gà tơ dần dần mọc dài hơn biến con mèo bé nhỏ xấu xí của chúng tôi thành một làn khói mỏng.\n" +
                    "\n" +
                    "Jim ngày càng thích làm bạn với con Khói. Có lúc Jim còn ôm nó theo khi anh ra ngoài thăm đàn gia súc, ghì sát nó vào chiếc quần vải bông của anh.\n" +
                    "\n" +
                    "Ngày Khói cùng Jim đi kiếm một con bé bị lạc cũng là ngày nó tròn ba tuổi. Cuộc lùng kiếm kéo dài trong nhiều giờ liền, và cứ mỗi lần dừng lại và bước ra khỏi xe phóng mắt tìm kiếm, Jim luôn để cửa xe mở. Bên ngoài là những cánh đồng nứt nẻ đầy những đám cỏ khô. Xa xa phía chân trời báo hiệu một cơn bão sắp đến, vậy mà vẫn không thấy dáng con bé đâu. Cảm thấy chán ngán và không chút suy nghĩ, Jim thò tay vào túi lấy hộp diêm và quẹt lên. Một tia lửa bắn xuống mặt đất và trong vài giây, cánh đồng bốc cháy.\n" +
                    "\n" +
                    "Lòng rối bòi, Jim chẳng còn tâm trí nào nghĩ đến con mèo. Chỉ sau khi dập tắt đám cháy và tìm ra con bé, anh mới quay về và chợt nhớ:\n" +
                    "\n" +
                    "- Con Khói đâu rồi! - Jim la lên - Chắc nó đã nhảy ra khỏi xe? Hay là nó đã về nhà.\n" +
                    "\n" +
                    "Không phải! Chúng tôi đều biết con Khói không bao giờ có thể tìm đường về nhà từ một nơi cách xa đến hai dặm. Trời bắt đầu đổ mưa khiến sự việc càng thêm rắc rối. Mưa nặng hạt đến nỗi chúng tôi không thể nào ra ngoài tìm kiếm nó.\n" +
                    "\n" +
                    "Jim trở nên quẫn trí và tự đổ lỗi cho mình. Chúng tôi bỏ cả ngày hôm sau để tìm kiếm, vừa mong nó cất tiếng kêu để chúng tôi biết mà tìm đến, vừa hiểu là nó khó có thể sống sót nếu gặp phải thú dữ. Nhưng rốt cuộc cũng chẳng ích gì!\n" +
                    "\n" +
                    "Hai tuần sau, vẫn không thấy con Khói về nhà. Chúng tôi e rằng nó đã chết đâu đó rồi vì khi mùa mưa bắt đầu thì cũng là lúc bầy diều hâu, chó sói và lũ chó hoang đi kiếm thức ăn.\n" +
                    "\n" +
                    "Sau đó khu vực chúng tôi lại bị một cơn mưa bão lớn chưa từng thấy ập đến. Nước từ trên trời như trút hết xuống nơi đây. Đến sáng, nước lũ phủ kín hàng dặm, khiến cho muông thú và trâu bò phải trồi dạt đến các đảo nằm rải rác ở các nơi cao hơn. Những con thỏ, gấu trúc, sáo và chuột sa mạc sợ hãi chờ nước rút bớt trong khi Jim và Scott bì bõm lội nước đưa đàn bê khát sữa về với mẹ của chúng an toàn.\n" +
                    "\n" +
                    "Trong lúc tôi cùng các con gái đang chăm chú quan sát thì đột nhiên Jaymee la lên:\n" +
                    "\n" +
                    "- Ba ơi! Có một con thỏ nhỏ xíu tội nghiệp nằm kia kìa. Ba cứu nó được không?\n" +
                    "\n" +
                    "Jim lội đến chỗ con vật nằm, khi đưa tay ra định bế sinh vật bé nhỏ ấy lên, anh bỗng giật bắn mình lùi lại như thể đang hoảng sợ. Anh la lên:\n" +
                    "\n" +
                    "- Không thể tin nổi. Chính là con Khói! - Giọng anh vỡ ra - Ôi! Con Khói bé bỏng tội nghiệp!\n" +
                    "\n" +
                    "Mắt tôi ứa lệ khi con mèo bé nhỏ thảm hại từ từ bò vào đôi tay dang rộng của Jim, người mà nó đã mỗi lúc mỗi dành nhiều tình cảm quý mến hơn. Anh ôm chặt cơ thể đang run rẩy của nó vào ngực, thủ thỉ những lời êm ái rồi nhẹ nhàng lau sạch bùn trên mặt nó. Suốt thời gian đó, con mèo dán chặt đôi mắt xanh vào anh với sự cảm thông không thành lời. Jim đã được tha thứ.\n" +
                    "\n" +
                    "Khói lại về nhà. Nhìn nó ngoan ngoãn để chúng tôi chăm sóc, trong lòng chúng tôi thấy vui hơn vì nó dường như đã khỏe lên.\n" +
                    "\n" +
                    "Nhưng con Khói chưa bao giờ thật sự khỏe mạnh. Một buổi sáng khi nó vừa tròn bốn tuổi, chúng tôi thấy nó nằm rũ trong chiếc ghế của Jim. Tim nó đã ngừng đập.\n" +
                    "\n" +
                    "Khi tôi bọc thân thể nhỏ xíu ấy trong chiếc khăn quàng cổ màu đỏ của Jim và đặt nó vào chiếc hộp đựng giày của lũ trẻ, tôi nghĩ về nhiều thứ mà chú mèo yêu quý đã dạy chúng tôi: lòng tin cậy, sự thương yêu và tinh thần đấu tranh với những điều lạ thường dù tất cả mọi người xung quanh cho rằng bạn không thể thắng. Nó nhắc nhở chúng tôi rằng không phải bề ngoài - mà chính những gì nằm sâu trong trái tim chúng ta - mới là điều đáng quý.',9,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đôi mắt biết nói','Những cơ hội lớn để ta giúp đỡ người khác hiếm khi xuất hiện, nhưng những cơ hội nhỏ để ta làm điều đó ở quanh ta mỗi ngày.\n" +
                    "\n" +
                    "- Sally Koch\n" +
                    "\n" +
                    "Đó là một buổi tối lạnh lẽo, rét buốt ở miền bắc Virginia cách đây đã nhiều năm. Bộ râu của ông lão cứng ngắc trong cái lạnh của mùa đông khi ông đợi có ai đó giúp ông sang sông. Sự chờ đợi dường như vô tận. Cơ thể ông tê cóng và cứng đờ bởi những cơn gió bấc giá lạnh.\n" +
                    "\n" +
                    "Bỗng ông nghe thấy tiếng ngựa phi nhịp nhàng đang đến gần men theo con đường đầy sương gió. Ông lo lắng nhìn khi một nhóm chàng trai phi ngựa rẽ qua khúc quanh, ông đã để cho người đầu tiên chạy qua mà chẳng hề gọi. Sau đấy, một người khác đi qua, rồi một người nữa. Lúc này, tuyết đã rơi, trông ông lão giống như một bức tượng bằng tuyết, ông đã thấy người kỵ sĩ cuối cùng. Khi người này đến gần, ông già ra dấu với người kỵ sĩ rồi nói:\n" +
                    "\n" +
                    "- Chào cậu, cậu có phiền đưa già này sang bên kia sông được không? Chẳng có lối nào để đi bộ được cả.\n" +
                    "\n" +
                    "Người kỵ sĩ ngồi trên ngựa đáp:\n" +
                    "\n" +
                    "- Được chứ, thưa bác. Bác nhảy lên đây nào.\n" +
                    "\n" +
                    "Thấy ông lão không thể nhấc nổi cơ thể đã gần như đông cứng khỏi mặt đất, chàng trai nhảy xuống và giúp ông leo lên ngựa. Chàng kỵ sĩ không chỉ đưa ông già sang sông mà còn mang ông đến nơi ông định đến cách đó vài dặm nữa.\n" +
                    "\n" +
                    "Khi đến gần một mái nhà tranh nhỏ xíu ấm cúng, chàng kỵ sĩ tò mò hỏi:\n" +
                    "\n" +
                    "- Thưa bác, cháu thấy bác đã để nhiều người cưõi ngựa khác chạy qua mà không nhờ lấy một ai để giúp qua sông. Khi cháu đến thì bác nhờ cháu ngay lập tức. Cháu thắc mắc không hiểu tại sao, vào một buổi tối mùa đông lạnh giá như thế này, bác lại đợi và nhờ người cuối cùng. Nếu cháu từ chối không giúp bác thì sao?\n" +
                    "\n" +
                    "Ông lão từ từ leo xuống ngựa, nhìn thẳng vào mắt chàng trai, đáp:\n" +
                    "\n" +
                    "- Bác đã ngồi đấy một lúc rồi. Bác nghĩ mình biết cách nhìn người. Khi bác nhìn vào mắt những chàng trai kia bác nhận ra ngay là họ chẳng quan tâm gì đến tình cảnh của bác cả. Nhờ họ giúp cũng không ích gì. Nhưng khi nhìn vào mắt cháu, lòng tốt và sự thương người hiện lên rất rõ. Bác biết rằng thái độ dịu dàng của cháu sẽ mở ra cho bác cơ hội được giúp đỡ lúc bác cần.\n" +
                    "\n" +
                    "Những lời ấm lòng đó của ông lão làm người kỵ sĩ hết sức cảm động.\n" +
                    "\n" +
                    "- Cháu hết sức cám ơn những gì bác vừa nói. - Anh nói với ông lão - Có lẽ sẽ chẳng bao giờ cháu quá bận rộn với chuyện riêng của mình mà không đáp lại nhữnggì người khác cần bằng lòng nhiệt thành cả.\n" +
                    "\n" +
                    "Hạnh phúc là nước hoa - bạn không thể vẩy lên người khác mà không làm vương vài giọt lên chính mình.\n" +
                    "\n" +
                    "- George Bernard Shaw',10,3)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tấm lòng cô giáo','Có những điểm cao trào quan trọng trong cuộc sống chúng ta, và hầu hết chúng đều đến tử sự khuyến khích của ai đó.\n" +
                    "\n" +
                    "- George Adams\n" +
                    "\n" +
                    "Chúng tôi đang trong giờ học của cô Virginia Deview, khúc khích cười, thọc mạnh vào nhau và bàn tán về những “tin tức” mới nhất trong ngày, như thuốc chải mí mắt màu tím đặc biệt mà Cindy đang dùng. Cô Deview hắng giọng và yêu cầu chúng tôi trật tự.\n" +
                    "\n" +
                    "- Bây giờ, - cô vừa nói vừa mỉm cười, - các em hãy suy nghĩ về nghề nghiệp trong tương lai của mình.\n" +
                    "\n" +
                    "Cả lớp dường như đồng loạt há hốc miệng vì ngạc nhiên. Nghề nghiệp của chúng tôi ư? Chúng tôi liếc nhìn nhau. Chúng tôi chỉ mới 13, 14 tuổi. Cô giáo này thật là lẩn thẩn!\n" +
                    "\n" +
                    "Đó là điều mà khá nhiều đứa trong bọn chúng tôi nhận xét về cô Deview, người có mái tóc luôn búi lên và hàm răng trên nhô ra. Be ngoài như thế khiến cô luôn là mục tiêu dễ dàng cho những tiếng cười khúc khích và những câu đùa ác nghiệt của lũ học trò.\n" +
                    "\n" +
                    "Cô cũng hay làm cho các học sinh bực bội vì những yêu cầu khắt khe của mình. Hầu hết chúng tôi đều xem nhẹ năng lực của cô.\n" +
                    "\n" +
                    "- Phải. Tất cả các em phải suy nghĩ về nghề nghiệp trong tương lai của mình. - Cô hăng hái nói như thể đây là điều tuyệt nhất mà cô làm được cho học sinh của mình. - Các em sẽ phải làm một đề tài nghiên cứu về nghề nghiệp trong tương lai của mình. Mỗi em sẽ phải phỏng vấn một ai đó làm trong lĩnh vực mà mình chọn, rồi thuyết trình trước lớp.\n" +
                    "\n" +
                    "Hôm đó, tất cả chúng tôi đều tan học với sự lúng túng. Có ai mà biết mình muốn làm gì khi mới 13 tuổi chứ? Tuy nhiên, tôi đã thu hẹp những lựa chọn của mình lại. Tôi thích nghệ thuật, ca hát và viết văn. Nhưng về nghệ thuật thì tôi rất tệ, còn khi tôi hát các chị tôi hay hét lên: “Này, làm ơn ngậm miệng lại dùm đi”. Lựa chọn duy nhất còn lại là viết văn.\n" +
                    "\n" +
                    "Và trong những giờ lên lớp kế tiếp của mình, cô Deview đều kiểm tra chúng tôi: “Chúng tôi đã đi đâu?”, “Các bạn nào đã chọn được nghề nghiệp cho mình?”. Cuối cùng, hầu hết chúng tôi đều đã chọn được một nghề nào đó; tôi đã chọn nghề làm báo. Điều đó có nghĩa là tôi phải đi phỏng vấn một phóng viên báo chí bằng xương bằng thịt. Điều này làm tôi rất lo.\n" +
                    "\n" +
                    "Tôi ngồi xuống trước mặt người phóng viên mà tôi gặp gần như không thể nói nổi lời nào. Ông ấy nhìn tôi rồi hỏi:\n" +
                    "\n" +
                    "- Cháu có mang theo cây viết nào không?\n" +
                    "\n" +
                    "Tôi lắc đầu.\n" +
                    "\n" +
                    "- Còn giấy viết thì sao?\n" +
                    "\n" +
                    "Tôi lại lắc đầu.\n" +
                    "\n" +
                    "Cuối cùng, chắc ông ấy nhận ra là tôi đang sợ hãi và đã cho tôi một lời khuyên hữu ích đầu tiên để có thể trở thành một nhà báo.\n" +
                    "\n" +
                    "- Bác chưa bao giờ đi đến bất kỳ nơi nào mà không mang theo bút và giấy viết cả, bởi vì ta chẳng bao giờ biết mình đang rơi vào chỗ nào.\n" +
                    "\n" +
                    "Trong 90 phút tiếp đó, người phóng viên đứng tuổi đã kể cho tôi nghe toàn những câu chuyện về các vụ cưóp, những trường hợp ăn chơi sa đọa và những vụ hỏa hoạn, ông kể về một đám cháy bi thảm đã cưóp đi sinh mạng của bốn người trong gia đình nọ mà ông không thể nào quên, ông bảo rằng ông vẫn có thể ngửi thấy mùi thịt của họ đang cháy...\n" +
                    "\n" +
                    "Vài ngày sau, tôi đã trình bày bài thuyết trình về nghề nghiệp của mình trước lớp hoàn toàn bằng trí nhớ một cách say sưa như bị thôi miên. Tôi nhận được điểm A cho toàn bộ công trình của mình.\n" +
                    "\n" +
                    "Khi năm học sắp kết thúc, một vài học sinh quá bất mãn đã quyết định trả thù cô Virginia Deview vì công việc khó khăn mà cô đã bắt chúng tôi làm. Khi cô đi đến một góc hành lang nọ, chúng đã cố hết sức ấn mạnh một cái bánh vào mặt cô. Cô chỉ bị xây xát nhẹ bên ngoài, nhưng trong lòng cô đã bị tổn thương rất nặng. Nhiều ngày sau đó, cô đã không đến trường. Khi tôi nghe được chuyện ấy, ruột tôi như bị ai cắt. Tôi cảm thấy xấu hổ cho chính mình và những đứa bạn của tôi, những người không biết làm điều gì tốt hơn là lên án một người phụ nữ vì vẻ bề ngoài của cô ấy, thay vì thán phục những phương pháp giảng dạy thú vị của cô.\n" +
                    "\n" +
                    "Nhiều năm sau, tôi đã quên tất cả mọi chuyện về cô Deview cũng như những nghề nghiệp chúng tôi đã lựa chọn. Tôi vào đại học và tìm kiếm một nghề nghiệp mới. Cha muốn tôi đi theo lĩnh vực kinh doanh và dường như đó là một lời khuyên đúng đắn vào lúc bấy giờ, nhưng oái oăm thay tôi chẳng có lấy một ký năng kinh doanh nào. Thế rồi tôi chợt nhớ đến cô Virginia Deview cùng ước muốn làm phóng viên hồi 13 tuổi. Tôi gọi điện cho ba mẹ.\n" +
                    "\n" +
                    "- Con sẽ đổi nghề - Tôi thông báo.\n" +
                    "\n" +
                    "Một sự im lặng nặng nề ở đầu dây điện thoại bên kia.\n" +
                    "\n" +
                    "- Đổi sang nghề gì? - Cuối cùng cha tôi cất tiếng.\n" +
                    "\n" +
                    "- Nghề làm báo ạ!\n" +
                    "\n" +
                    "Tôi có thể đọc thấy sự không vui qua giọng nói của ba mẹ, nhưng họ không ngăn cản tôi. Họ chỉ nhắc nhở tôi rằng đây là một lĩnh vực đầy cạnh tranh và tôi đã muốn tránh nó như thế nào.\n" +
                    "\n" +
                    "Họ nói đúng. Tuy nhiên nghề phóng viên báo chí đã đem lại cho tôi điều gì đó; nó nằm trong máu thịt của tôi. Nó đem đến cho tôi sự tự do để đến được với tất cả những người xa lạ và hỏi họ về những điều đã xảy ra. Nó luyện cho tôi cách đặt câu hỏi và tìm được câu trả lời trong cả nghề nghiệp lẫn cuộc sống riêng tư của mình. Nó mang đến cho tôi sự tự tin.\n" +
                    "\n" +
                    "Trong 12 năm qua, nghề phóng viên đem lại cho tôi Sự hài lòng và rất nhiều điều ngạc nhiên thú vị. Tôi viết mọi chuyện từ những kẻ giết người đến những vụ rơi máy bay và sau cùng là viết theo sở trường của mình. Tôi thích viết về những giây phút bi thảm và mong manh trong cuộc sống con người, bởi lẽ tôi cảm thấy điều đó giúp họ trong một phương diện nào đó.\n" +
                    "\n" +
                    "Một ngày nọ, khi tôi nhắc điện thoại lên, một cơn sóng ký niệm chợt ùa về trong tôi. Tôi nhận ra rằng nếu không có sự ủng hộ của cô Virginia De view, tôi sẽ không có được vị trí hiện nay của mình.\n" +
                    "\n" +
                    "Có lẽ cô sẽ chẳng bao giờ biết được nếu không có sự giúp đỡ của cô, tôi đã không trở thành một phóng viên và một nhà văn. Có thể tôi đang ngụp lặn trong thế giới kinh doanh ở một nơi nào đó, với những rủi ro to lớn bao vây lấy tôi mỗi ngày. Tôi tự hỏi giờ đây có bao nhiêu học sinh khác đã từng là học trò của cô nhận thức được tầm quan trọng của bài tập nghiên cứu về nghề nghiệp đó.\n" +
                    "\n" +
                    "Người ta luôn hỏi rằng:\n" +
                    "\n" +
                    "- Anh đã chọn nghề báo như thế nào?\n" +
                    "\n" +
                    "- À, anh có biết không, có một cô giáo...\n" +
                    "\n" +
                    "Tôi luôn bắt đầu như thế và thầm cám ơn cô Deview.\n" +
                    "\n" +
                    "Tôi mong rằng những học trò của cô khi ngẫm nghĩ về những ngày còn đi học của mình, sẽ còn giữ lại trong tâm trí hình ảnh của một người giáo viên độc thân - cô Virginia Deview - rất riêng, rất khác biệt của họ. Có lẽ họ sẽ cám ơn cô ấy trước khi quá trễ.',11,3)");

            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mark Twain và người phụ nữ kiêu ngạo','Trong một bữa tiệc, Mark Twain ngồi đối diện với một người phụ nữ. Theo lẽ lịch sự, ông đã nói với người này: “Cô thật là xinh đẹp!”.\n" +
                    "\n" +
                    "Người phụ nữ đó lại không hề cảm kích, mà còn cao ngạo nói: “Rất tiếc là tôi không có cách nào để nói lời khen tương tự như thế với ông!”.\n" +
                    "\n" +
                    "Mark Twain rất bình thản, nói: “Không sao cả, cô có thể giống như tôi vậy, nói một lời nói dối là được rồi”.\n" +
                    "\n" +
                    "Người phụ nữ nghe xong, xấu hổ quá, phải cúi gầm mặt xuống mà không nói được lời nào.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Tảng đá mà bạn ném ra, người bị nó làm cho vấp té sẽ luôn luôn là chính bản thân bạn;\n" +
                    "\n" +
                    "Bạn nói lời cay nghiệt, sau cùng cũng sẽ tự mình rước lấy nhục nhã mà thôi.',1,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chuột sa hũ gạo','Một con chuột rơi vào trong lu gạo, số gạo trong lu vẫn còn một nửa, sự cố ngoài ý muốn này khiến nó vui mừng không sao tả được.\n" +
                    "\n" +
                    "Sau khi xác định là không có nguy hiểm gì, nó liền bắt đầu cuộc sống ăn rồi lại ngủ, ngủ rồi lại ăn trong cái lu gạo.\n" +
                    "\n" +
                    "Rất mau, lu gạo sắp cạn kiệt, nhưng nó rốt cuộc vẫn không thoát khỏi sự cám dỗ của những hạt gạo, nên tiếp tục ở lại trong lu. Cuối cùng, gạo đã ăn hết, chuột ta mới phát hiện rằng mình không thể nhảy ra ngoài được nữa, lực bất tòng tâm.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Cuộc đời của chúng ta xem như rất yên bình nhưng thật ra khắp nơi đều đầy rẫy nguy cơ, cần phải giữ cho mình quan niệm sống ổn định, từ đó mà biết cân nhắc đến an nguy.',2,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Con thỏ câu cá bằng cà rốt','Ngày đầu tiên, chú thỏ con đi câu cá, không thu hoạch được gì cả.\n" +
                    "\n" +
                    "Ngày thứ hai, nó lại đi câu cá, kết quả vẫn không đổi.\n" +
                    "\n" +
                    "Ngày thứ ba, nó vừa đến nơi, một con cá lớn từ trong hồ nhảy lên, lớn tiếng quát: “Nếu như ngươi còn dám dùng cà rốt để làm đồ ăn cho cá, ta sẽ làm thịt ngươi”.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Những gì bạn cho đi đều là những gì bạn muốn cho, chứ nó không nhất định là những gì mà đối phương muốn; thế nên điều bạn cho đi ấy trong con mắt người ta căn bản vốn không có giá trị gì cả. Hãy biết cân nhắc đến người khác để giá trị cuộc sống của bạn thêm ý nghĩa.',3,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bệnh nhân ung thư “tưởng rằng” cuộc phẫu thuật đã thành công','Tôi có một người bạn là bác sĩ. Một lần anh làm phẫu thuật cho bệnh nhân ung thư, sau khi mổ ra mới phát hiện chỗ bị viêm cắt bỏ không được, anh đành phải may lại, rồi đi giải thích tình huống với bệnh nhân. Bệnh nhân đó đến từ vùng quê, nghe không hiểu thuật ngữ y khoa, thế nên nghe xong thì vững tin rằng phẫu thuật xong rồi thì bệnh sẽ khỏi.\n" +
                    "\n" +
                    "Bác sĩ không còn cách nào khác, đành phải để ông xuất viện.\n" +
                    "\n" +
                    "Một năm sau tái khám, bệnh quả nhiên đã khỏi hẳn, các tế bào ung thư đã hoàn toàn biến mất.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Tâm thái vui vẻ lạc quan chính là phương thức phẫu thuật tốt nhất vậy.',4,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Nhân duyên vợ chồng','Năm đó, anh đang ngồi đợi bạn trong quán cà phê. Một người con gái bước đến hỏi: “Anh có phải là người mà dì Vương giới thiệu đến để xem mắt hay không?”.\n" +
                    "\n" +
                    "Anh ngẩng đầu lên nhìn cô một cái, bất chợt phát hiện đây chính là mẫu người mình thích, lòng nghĩ thầm sao không “lỡ nhầm rồi đã nhầm cho trót luôn”, thế là vội vàng đáp: “Đúng vậy, mời ngồi”.\n" +
                    "\n" +
                    "Ngày kết hôn, anh liền đem sự thật này nói với vợ, người vợ cười cười một cái, nói: “Em cũng không phải là đến xem mắt, chỉ là mượn cớ để bắt chuyện với anh thôi……”\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Khi cơ duyên đã đến rồi, thì đừng nên do dự mà hãy nắm chặt lấy nó.',5,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Hoa khôi lớp xấu xí','Các sinh viên nữ công khai bỏ phiếu bầu chọn hoa khôi của lớp, Tiểu Mai là người có dung mạo bình thường nhưng cô đa đứng ra nói mọi người rằng: “Nếu như tôi được chọn, qua vài năm sau, các chị em ngồi ở đây có thể tự hào mà nói với chồng của mình rằng, ‘hồi em học đại học, em còn xinh đẹp hơn cả hoa khôi trong lớp cơ đấy!’”.\n" +
                    "\n" +
                    "Kết quả là cô ấy đã được bầu chọn với số phiếu gần như tuyệt đối.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Thuyết phục người khác ủng hộ bạn, không nhất định là phải chứng minh rằng bạn xuất sắc hơn người khác như thế nào, mà là cần để cho người ta biết được rằng nhờ có bạn mà họ mới trở nên ưu tú hơn và có nhiều thành tựu hơn.',6,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Ông lão vứt bỏ đôi giày','Chuyến xe lửa đang chạy trên đường cao tốc, Gandhi không cẩn thận làm rơi một chiếc dép mới mua ra ngoài cửa sổ, mọi người chung quanh đều cảm thấy tiếc cho ông. Bất ngờ, ông liền ném ngay chiếc giày thứ hai ra ngoài cửa sổ đó. Hành động này của Gandhi khiến mọi người sửng sốt, thế là ông bèn từ tốn giải thích: “Chiếc giày này bất luận đắt đỏ như thế nào, đối với tôi mà nói nó đã không còn có ích gì nữa, nếu như có ai có thể nhặt được đôi giày, nói không chừng họ còn có thể mang vừa nó thì sao!”.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Đối với nỗi thống khổ đã định sẵn là không thể vãn hồi, chi bằng hãy buông bỏ từ sớm.',7,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Hai con hổ số phận khác nhau','Có hai con hổ, một con ở trong chuồng, một con nơi hoang dã.\n" +
                    "\n" +
                    "Hai con hổ đều cho rằng hoàn cảnh của bản thân mình không tốt, đôi bên đều ngưỡng mộ đối phương, thế là chúng quyết định thay đổi thân phận với nhau. Lúc mới bắt đầu, cả hai đều vô cùng vui vẻ, nhưng không lâu sau đó, hai con hổ đều chết cả: một con vì đói mà chết, một con u sầu mà chết.\n" +
                    "\n" +
                    "Gợi ý nhỏ:\n" +
                    "\n" +
                    "Có những lúc, mọi người nhắm mắt làm ngơ đối với hạnh phúc của chính bản thân mình, để rồi luôn để mắt đến hạnh phúc của những người khác. Thật ra, những gì mà bạn đang có chính là những điều mà người khác phải ngưỡng vọng.\n" +
                    "\n" +
                    "Cuộc đời là thế, nhiều chuyện xảy ra theo cách không thể ngờ tới, hy vọng sau khi đọc những câu chuyện này, mọi lúc mọi nơi ai cũng có thể tự nhắc nhở bạn thân mình vậy.',8,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đĩa kem và tiền tip','Vào một ngày đẹp trời, tại quán cafe của một khách sạn nọ có một cậu bé trạc tầm 10 tuổi bước vào, sau khi nhìn xung quanh và chọn cho mình một cái bàn trống trãi, cậu bé ngồi xuống và bắt đầu gọi món.\n" +
                    "Cô phục vụ bước đến đặt một cốc nước trước mặt cậu bé và hỏi cậu dùng gì.\n" +
                    "\"Một đĩa kem mứt có giá bao nhiêu ạ?\" cậu bé khẽ khàng hỏi.\n" +
                    "\"50 cent\" - Cô gái phục vụ trả lời một cách nhát gừng, tỏ vẻ không thích.\n" +
                    "Cậu bé lôi từ trong túi quần ra một mớ những đồng xu và bắt đầu đếm. Cô gái nhìn tỏ vẻ ái ngại và hơi khó chịu.\n" +
                    "\"Thế một đĩa kem trắng không có mứt thì giá bao nhiêu ạ? cậu bé hỏi tiếp. Lúc này trong quán cafe đang có vài người khách đang chờ phục vụ, cô phục vụ bắt đầu mất kiên nhẫn và tỏ vẻ khó chịu thật sự.\n" +
                    "\"35 cent\", cô trả lời một cách cộc cằn.\n" +
                    "Cậu bé đếm lại các đồng xu một lần nữa. \"Vậy cô cho cháu 1 đĩa kem trắng không mứt nhé\", cậu nói.\n" +
                    "Cô gái phục vụ mang đĩa kem không mứt cùng với tờ hóa đơn đặt lên bàn trước mặt cậu bé và nhanh chóng bước sang các bàn khác để phục vụ các vị khách đang chờ đợi. Một  lúc sau cậu bé ăn kem xong và đặt tiền lên bàn và rời khỏi quán cafe.\n" +
                    "Lúc này cô gái bước đến bàn của cậu bé để dọn dẹp và những gì cô đang nhìn thấy khiến cô nghẹn ngào,  xúc động đến không thể nói nên lời. Bên cạnh chiếc đĩa trống là 15 cent, tiền tip của cô.',9,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Lòng biết ơn.','Một ngày nọ, Đức Chúa Trời động lòng thương xót khi các con chiên đang ra sức cầu nguyện, xin ngài hãy ban phước lành cho họ. Thấy vậy Đức Chúa Trời bèn kêu hai thiên thần mà mình tin  tưởng nhất đến và bảo rằng:\n" +
                    "- \"Hôm nay ta có việc cho hai con đây\".\n" +
                    "- \"Ngài cần chúng con làm gì thưa Đức Chúa Trời\". Một trong hai thiên thần hỏi \n" +
                    "-\"Hiện tại, ở dưới thế gian có rất nhiều người ăn ở hiền lành đức độ, rất vừa lòng của ta, họ cầu xin ta hãy thương xót thế gian và hãy ban hòa bình cho cả thế giới.  Vì vậy hôm nay ta sai hai con xuống thế gian với hai chiếc túi này\" Vừa nói Đức Chúa Trời vừa trao cho những thiên thần 2 chiếc túi. \"Chiếc túi thần kì này có thể chứa đựng được tất cả nguyện vọng của nhân loại, các con hãy đi và mang về cho ta những lời cầu xin của loài người, ta sẽ đáp ứng tất cả những lời nguyện ước đó vì ta rất giàu lòng thương xót\".\n" +
                    "Thế rồi hai thiên sứ từ biệt Ngài và đi xuống trần gian. Một thời gian ngắn sau, hai thiên thần trở về mang theo hai chiếc túi nặng trĩu toàn những lời ước nguyện của con người và đó toàn là những điều ước trần tục như xin được giàu có, xin được thông minh xinh đẹp, cầu xin tình duyên, sức khỏe....Dĩ nhiên tất cả những điều ước đó không trái với luân thường đạo lý, không trái với thuần phong mỹ tục và đạo đức con người, nên Đức Chúa Trời đều chấp nhận hết cả, vì Ngài rất giàu lòng nhân ái.Sau khi đã ban hết tất cả các nguyện ước cho con người. Ngài lại sai hai thiên thần đến và bảo rằng:\n" +
                    "- \"Ta đã ban hết cho con người những gì họ mong ước, vậy hôm nay ta sai hai con đến, để hai con xuống trần gian và xem nhân loại đang cảm nhận như thế nào về phước lành mà ta đã ban cho họ\". Nói xong Ngài tiếp tục trao cho họ hai chiếc túi như lần trước. \n" +
                    "Lần này hai thiên thần đã nán ở lại trần gian khá lâu, nhưng khi trở về hai chiếc túi nhẹ như không. Thấy vậy Đức Chúa Trời lại hỏi hai thiên sứ:\n" +
                    "- \"Sao trông hai con buồn thế?\"\n" +
                    "Hai thiên sứ cung kính trả lời rằng:\n" +
                    "- \"Thưa Đức Chúa Trời, xin Ngài đừng trách và phạt chúng con, vì chúng con không làm tốt việc mà Ngài đã giao phó, chúng con xuống trần gian và đã ở lại rất lâu, nhưng chúng con nhận được rất ít lời tri ân của con người thưa Ngài\".\n" +
                    "Sau khi nghe hai thiên sứ đáp, Đức Chúa Trời chỉ mỉm cười và không nói gì cả, bởi vì Ngài rất giàu lòng thương xót. Ngài không trách gì hai thiên sứ cả cũng như con người vì Ngài đầy lòng nhân ái.\n" +
                    "Con người là vậy, khi ai đó đối xử không tốt với họ, thì họ sẽ hận thù, trách móc, giận hờn nhau, nhưng khi được giúp đỡ yêu thương, thì có mấy ai biết ơn và nhớ ơn ân nhân của mình chứ.',10,4)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tiêu đề 42','Nội dung 42',11,4)");

            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Sợi dây thừng và con voi.','Có một du khách nọ đi ngang qua qua một khu vực và quan sát thấy cảnh tượng lạ kỳ và khó hiểu, anh ta dừng lại quan sát, trước mắt anh ta là một con voi to lớn đang bị trói lại bởi một sợi dây thừng mỏng manh vào chân, chẳng phải là những sợi dây xích dày cộm, hay những lồng sắc hầm hố, chỉ đơn giản là một sợi dây mỏng manh mà thôi. Dĩ nhiên việc giật đứt sợi dây đó và thoát đi tự do là điều quá dễ dàng với con voi đó, nhưng chắc chắn là có một lí do nào đó mà nó không làm vậy.\n" +
                    "Thế là anh ta lại gần người quản tượng và hỏi rằng tại sao con vật này chỉ đứng vậy mà không cố thoát đi.\n" +
                    "- \"Dễ hiểu thôi\", người quản tượng trả lời. \"Khi chúng còn là voi con và bé hơn bây giờ rất nhiều lần, thì chúng tôi dùng dây thừng trói chúng là đủ, điều đó khiến chúng nghĩ rằng chúng không bao giờ giật đứt được sợi dây thừng mặc dù chúng đã lớn. Con voi này vẫn nghĩ rằng sợi dây thừng vẫn đủ sức trói chúng nên chúng chẳng bao giờ thử cố thoát ra\".\n" +
                    "Vị du khách đó rất ngạc nhiên. Hóa ra những con voi này rất dễ dàng giật đứt sợi dây thừng đó bất cứ lúc nào, nhưng vì chúng nghĩ là không thể được nên cứ đứng im mãi một chỗ.\n" +
                    "Cũng giống như con voi kể trên, bao nhiêu người trong chúng ta lãng phí nhiều cơ hội trong cuộc sống chỉ đơn giản vì ta nghĩ rằng ta không thể làm được điều gì đó vì trước đó ta đã thử và thất bại.\n" +
                    "Thất bại là mẹ thành công, quan trọng là ta không bao giờ được ngừng nỗ lực.',1,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Con lừa trong giếng sâu.','Có một con lừa bị trượt chân và té vào một cái giếng cạn khá sâu. Chủ của nó thấy vậy liền tìm mọi cách cứu nó, nhưng mặc dù đã dùng nhiều cách vẫn không cứu được nó, chán nản cuối cùng ông ta quyết định lấp giếng chôn sống nó, vì ông nghĩ làm việc là sẽ giúp nó giải thoát nhanh chóng, còn hơn là kêu rống trong tuyệt vọng cho đến chết và cũng để tránh trường hợp những người khác bị rớt xuống giếng này.\n" +
                    "Ông ta dùng xẻng xúc từng đống cát lờn và hất vào giếng. Đất cát đổ xuống đầu con lừa từ trên cao. Lúc đầu con lừa chỉ biết đứng đó kêu gào thảm thiết, nhưng sau một hồi, nó rũ sạch đất cát trên mình và giẫm lên đống cát ấy để đứng lên, rồi từ từ dùng chân đùn đống cát đó đến chỗ thấp hơn cho nó bằng phẳng và cân đối. \n" +
                    "Cứ như thế nó liên tục được đứng trên đống cát vừa được đổ xuống, càng nhiều cát đổ xuống thì con lừa càng được đứng cao hơn. Tới trưa thì con lừa đã thoát ra được cái giếng cạn đó.\n" +
                    "Nếu bạn không để khó khăn và thử thách làm mất đi ý chí mà vẫn cố gằng vượt qua thì chính những khó khăn đó lại đưa bạn lên cao hơn và vươn đến thành công.',2,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Không phải ai cũng đủ may mắn','Anh 28 tuổi, vừa lấy vợ chưa được một năm, hai người đang có kế hoạch năm tới sẽ có em bé. Là trụ cột và có khả năng kiếm tiền nhiều nhất trong nhà, anh gánh vác kinh tế cho cả gia đình, họ hàng. \n" +
                    "Rồi một ngày nọ, chị thấy anh mang về một chiếc xe phân khối lớn, ước mơ bao lâu nay của anh cuối cùng cũng đã trở thành hiện thực, chị cũng vui và hạnh phúc với anh dù trong lòng cũng có chút ghen tị với chiếc xe vì chồng mình chăm nó hơn chăm vợ.\n" +
                    "Nhưng rồi...\n" +
                    "Anh chạy xe chưa được một tuần thì xe hỏng, hỏng...vì gặp tai nạn trên đường. Ngày chị đi nhận lại xe mà khóc ngất, từng vệt buồn lăn dài trên khuôn mặt người phụ nữ đã xác xơ mấy tháng trời. Xe đã đưa về đến nhà nhưng...giờ đâu còn ai chạy và chăm sóc nó nữa đâu?\n" +
                    "Cậu là con một, vừa đỗ đại học, á khoa một trường danh tiếng, cùng lúc đó có 2 trường đại học tại Mỹ cũng đồng ý trao học bổng toàn phần cho cậu. Bố mẹ cậu tự hào khôn xiết về cậu, đi đâu cũng khoe với mọi người, lòng tràn đầy hạnh phúc. Mẹ bảo với cậu, thích gì mẹ cũng chịu cả, nghe vậy cậu lí nhí: \"Con muốn tự chạy xe đi xuyên Việt một chuyến\". Mẹ cậu không an tâm lắm với đề nghị đó, nhưng cũng gật đầu đồng ý. Rồi cậu cũng lên đường theo ước mơ bấy lâu nay. Mỗi nơi cậu đi qua, cậu đều chụp hình gửi về cho bố mẹ coi, hai ông bà đến khổ sở vì lo lắng đếm ngược từng ngày qua những bức hình con trai gửi về, thế rồi cũng đến ngày cậu đặt chân đến nơi tận cùng đất nước Đất Mũi Cà Mau hoàn thành chuyến đi xuyên Việt. Cậu xin phép bố mẹ ở lại Sài Gòn chơi 2 ngày rồi sẽ bay về. Xe máy cậu gửi theo tàu hỏa về trước. Đêm Sài Gòn vui lắm, cậu uống rượu say đến mức bị cảm lạnh, mẹ bảo cậu vào bệnh viện khám, cậu cười xòa không sao. Ngày xe gửi ra đến ga Hà Nội mà chẳng ai ra nhận cả \n" +
                    "Vì...\n" +
                    "Cả nhà cậu bay vào Sài Gòn hết cả. Đến giờ cũng đã gần 20 năm rồi, người ta vẫn thấy mẹ cậu thỉnh thoảng ngồi một mình trước hiên nhà, tự hào kể chuyện với ai chẳng biết, rằng là con trai bà vừa đỗ á khoa một trường đại học danh tiếng và dành được hai suất học bổng của Mỹ.\n" +
                    "Con ngõ nhỏ dẫn về nhà quanh co và hẹp, chưa được mắc đèn nên tối om, bé vốn sợ bóng tối, nhưng vì hôm nay ba đi công tác về nên bé vẫn ráng mon men ra tận đầu ngõ đón. Ba của bé làm công nhân theo công trình đi khắp nơi, nhưng ba thường xuyên viết thư gửi về cho bé. Bé thích đọc thư tay ba viết, rồi bé cũng viết thư tay gửi lại cho ba. Bé kể chuyện cho ba nghe về mẹ, về con mèo lười trên bếp, về đàn gà mới nở, về cây trái trong vườn, Ba viết cho bé không nhiều, nhưng kết thúc thư lúc nào cũng có 3 từ: \"Ba thương con!\". Mỗi lần ba về bé đều ra đón ba như vậy cả, ba sẽ ôm bé vào lòng, hôn lên trán rồi đặt bé ngồi lên đôi vai lực lưỡng của ba. Hôm nay bé vừa đi vừa tưởng tượng ra hơi ấm của ba, vừa nghĩ về nụ hôn của ba, vừa tự thủ thỉ trong đầu câu \"Con cũng thương ba lắm!\", chỉ vậy thôi cũng giúp bé thấy rằng bóng tối không còn đáng sợ nữa, nhưng bé chờ mãi, chờ mãi mà không thấy ba đâu cả. Mẹ từ đâu chạy đến cầm tay bé, mắt đỏ hoe:\n" +
                    "- Về ngủ thôi con! Mai còn đến trường. Hôm nay ba về muộn. Ba hứa sẽ hôn con khi ba về đến.\n" +
                    "Bé ngoan ngoãn dạ một tiếng rồi theo mẹ về, ngang qua nhà chú Tư đầu xóm, nghe cái đài rè rè đưa tin có chuyến xe khách, từ công trường về huyện gặp nạn, không ai còn sống sót.\n" +
                    "Hóa ra cuộc sống của mỗi con người không đơn giản như người ta thường nói, cũng không phải ai cũng đủ may mắn để trải qua chuyện :\"sinh, lão, bệnh,tử\" như người ta vẫn thường hay nói cho nhau nghe. Mọi chuyện đều có thể xảy ra và có nhiều khi ta chỉ biết lặng nhìn những người ta thương yêu ra đi mà bất lực không thể làm gì được.\n" +
                    "Mẹ bảo rằng, nếu con yêu thương ai thì con cứ nói, con quan tâm ai thì hãy cứ thể hiện cho họ thấy, dù họ có đáp lại hay không, dù họ có cảm động hay nhìn con như một sự phiền nhiễu, thì con cũng đừng ngại bày tỏ yêu thương khi còn có thể, phiền nhiễu đến mấy thì cũng vẫn là yêu thương. Con nghe vậy không ngần ngại nói rằng: \"CON YÊU MẸ\".\n" +
                    "Cuộc đời này chẳng có gì là mãi mãi, nhưng ta luôn có thể tạo ra những khoảnh khắc mãi mãi, nhưng ta luôn có thể tạo ra những khoảnh khắc mãi mãi trong cuộc đời khi còn bên nhau.',3,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Khoai tây, trứng và cafe','Có một cô gái trẻ hay phàn nàn với bố mình rằng cuộc sống của cô thật là khốn khổ và cô chẳng biết phải làm thế nào để cải thiện điều đó. Cô đã luôn cố gắng chiến đấu và luôn cố gắng vượt qua nghịch cảnh. Tuy nhiên \"đời không là mơ\" khi cô đang giải quyết vấn đề này thì vấn đề khác ập đến, cô thấy thật sự quá rồi rắm và không biết phải làm gì và bắt đầu từ đâu.\n" +
                    "Bố của cô là một đầu bếp, ông dẫn cô vào bếp ăn. Ông đặt  ba cái nồi đầy nước lên bếp và đun sôi, khi cả 3 cái nồi đều đã sôi, ông lần lượt bỏ vào nồi thứ nhất những củ khoai tây, những quả trứng vào cái nồi tiếp theo và những hạt cafe vào cái nồi cuối cùng.\n" +
                    "Ông tiếp tục đun và chẳng nói với cô một tiếng nào cả. Cô thì không hiểu gì cả nên cứ tiếp tục than vãn và dường như đã mất hết kiên nhẫn, cô không ngừng tự hỏi cha mình đang làm gì.\n" +
                    "Sau hơn 20 phút, người cha tắt bếp. Ông vớt khoai tây, trứng ra khỏi nồi và đặt chúng vào một cái chén. \n" +
                    "Riêng cafe thì ông đổ vào một chiếc ly. Rồi ông quay qua nhìn cô con gái đang ngơ ngác đứng nhìn và ông hỏi: \" Thế nào con gái, con có thấy gì không?\"\n" +
                    "- \" Khoai tây, trứng và cafe ạ\" Cô gái vội vàng trả lời.\n" +
                    "- \"Lại gần đây hơn đi con\" người cha nói \"Và thử chạm vào khoai tây xem\". Cô gái làm theo và thấy chúng bị mềm ra. Người cha yêu cầu cô gái cầm trứng lên và bóc ra. Sau khi bóc hết lớp vỏ, cô thấy trứng đã chín và rất đặc. Cuối cùng ông yêu cầu cô gái thử một ngụm cafe. Hương vị đậm đà của cafe khiến cô thích thú mỉm cười. Đến lúc này cô mới quay ra hỏi bố của mình \"Bố, thế chúng có ý nghĩa gì?\"\n" +
                    "Ông bắt đầu giải thích rằng, khoai tây, trứng và cafe đều phải đối mặt với cùng một thử thách đó là nước sôi. \n" +
                    "Tuy nhiên, cách chúng bị ảnh hưởng lại hoàn toàn khác nhau.\n" +
                    "Khoai tây mạnh mẽ, cứng rắn nhưng cũng vì quá cứng rắn, nên khi gặp nước sôi, nó bị mềm và yếu đuối.\n" +
                    "Những quả trứng dễ vỡ, nếu cứ được lớp vỏ mỏng manh bảo bọc thì bên trong nó vẫn sẽ chỉ là chất lỏng yếu ớt. Chỉ đến khi gặp nước sôi, thì bên trong quả trứng mới trở nên đặc và chắc chắn.\n" +
                    "Tuy nhiên chỉ có những hạt cafe thì mới thật đặc biệt. Khi bị đặt vào nước sôi, chúng đã tan thành nước và tạo nên sự mới mẻ. \n" +
                    "Vậy thứ nào sẽ ứng với con \" Khi thử thách đến, con sẽ ứng phó như thế nào. Giống như khoai tây, như trứng hay giống như cafe?\" người cha từ tốn hỏi cô con gái đang đứng chiêm nghiệm những gì đang thấy. Thật sự cô đang tiếp thu được những bài học rất bổ ích và quý giá từ người cha đáng kính của mình.\n" +
                    "\"Trong cuộc sống, vấn đề luôn xuất hiện ở quanh ta, nhưng chỉ có duy nhất một điều quan trọng là điều gì sẽ xảy ra với chính bản thân ta và cách ta thích ứng cũng như vượt qua nó như thế nào mà thôi\"',4,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, ' Người công nhân kỳ lạ.','Nội dung 55',5,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đôi mắt biết nói','Những cơ hội lớn để ta giúp đỡ người khác hiếm khi xuất hiện, nhưng những cơ hội nhỏ để ta làm điều đó ở quanh ta mỗi ngày.\n" +
                    "\n" +
                    "- Sally Koch\n" +
                    "\n" +
                    "Đó là một buổi tối lạnh lẽo, rét buốt ở miền bắc Virginia cách đây đã nhiều năm. Bộ râu của ông lão cứng ngắc trong cái lạnh của mùa đông khi ông đợi có ai đó giúp ông sang sông. Sự chờ đợi dường như vô tận. Cơ thể ông tê cóng và cứng đờ bởi những cơn gió bấc giá lạnh.\n" +
                    "\n" +
                    "Bỗng ông nghe thấy tiếng ngựa phi nhịp nhàng đang đến gần men theo con đường đầy sương gió. Ông lo lắng nhìn khi một nhóm chàng trai phi ngựa rẽ qua khúc quanh, ông đã để cho người đầu tiên chạy qua mà chẳng hề gọi. Sau đấy, một người khác đi qua, rồi một người nữa. Lúc này, tuyết đã rơi, trông ông lão giống như một bức tượng bằng tuyết, ông đã thấy người kỵ sĩ cuối cùng. Khi người này đến gần, ông già ra dấu với người kỵ sĩ rồi nói:\n" +
                    "\n" +
                    "- Chào cậu, cậu có phiền đưa già này sang bên kia sông được không? Chẳng có lối nào để đi bộ được cả.\n" +
                    "\n" +
                    "Người kỵ sĩ ngồi trên ngựa đáp:\n" +
                    "\n" +
                    "- Được chứ, thưa bác. Bác nhảy lên đây nào.\n" +
                    "\n" +
                    "Thấy ông lão không thể nhấc nổi cơ thể đã gần như đông cứng khỏi mặt đất, chàng trai nhảy xuống và giúp ông leo lên ngựa. Chàng kỵ sĩ không chỉ đưa ông già sang sông mà còn mang ông đến nơi ông định đến cách đó vài dặm nữa.\n" +
                    "\n" +
                    "Khi đến gần một mái nhà tranh nhỏ xíu ấm cúng, chàng kỵ sĩ tò mò hỏi:\n" +
                    "\n" +
                    "- Thưa bác, cháu thấy bác đã để nhiều người cưõi ngựa khác chạy qua mà không nhờ lấy một ai để giúp qua sông. Khi cháu đến thì bác nhờ cháu ngay lập tức. Cháu thắc mắc không hiểu tại sao, vào một buổi tối mùa đông lạnh giá như thế này, bác lại đợi và nhờ người cuối cùng. Nếu cháu từ chối không giúp bác thì sao?\n" +
                    "\n" +
                    "Ông lão từ từ leo xuống ngựa, nhìn thẳng vào mắt chàng trai, đáp:\n" +
                    "\n" +
                    "- Bác đã ngồi đấy một lúc rồi. Bác nghĩ mình biết cách nhìn người. Khi bác nhìn vào mắt những chàng trai kia bác nhận ra ngay là họ chẳng quan tâm gì đến tình cảnh của bác cả. Nhờ họ giúp cũng không ích gì. Nhưng khi nhìn vào mắt cháu, lòng tốt và sự thương người hiện lên rất rõ. Bác biết rằng thái độ dịu dàng của cháu sẽ mở ra cho bác cơ hội được giúp đỡ lúc bác cần.\n" +
                    "\n" +
                    "Những lời ấm lòng đó của ông lão làm người kỵ sĩ hết sức cảm động.\n" +
                    "\n" +
                    "- Cháu hết sức cám ơn những gì bác vừa nói. - Anh nói với ông lão - Có lẽ sẽ chẳng bao giờ cháu quá bận rộn với chuyện riêng của mình mà không đáp lại nhữnggì người khác cần bằng lòng nhiệt thành cả.\n" +
                    "\n" +
                    "Hạnh phúc là nước hoa - bạn không thể vẩy lên người khác mà không làm vương vài giọt lên chính mình.\n" +
                    "\n" +
                    "- George Bernard Shaw',6,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tấm lòng cô giáo','Có những điểm cao trào quan trọng trong cuộc sống chúng ta, và hầu hết chúng đều đến tử sự khuyến khích của ai đó.\n" +
                    "\n" +
                    "- George Adams\n" +
                    "\n" +
                    "Chúng tôi đang trong giờ học của cô Virginia Deview, khúc khích cười, thọc mạnh vào nhau và bàn tán về những “tin tức” mới nhất trong ngày, như thuốc chải mí mắt màu tím đặc biệt mà Cindy đang dùng. Cô Deview hắng giọng và yêu cầu chúng tôi trật tự.\n" +
                    "\n" +
                    "- Bây giờ, - cô vừa nói vừa mỉm cười, - các em hãy suy nghĩ về nghề nghiệp trong tương lai của mình.\n" +
                    "\n" +
                    "Cả lớp dường như đồng loạt há hốc miệng vì ngạc nhiên. Nghề nghiệp của chúng tôi ư? Chúng tôi liếc nhìn nhau. Chúng tôi chỉ mới 13, 14 tuổi. Cô giáo này thật là lẩn thẩn!\n" +
                    "\n" +
                    "Đó là điều mà khá nhiều đứa trong bọn chúng tôi nhận xét về cô Deview, người có mái tóc luôn búi lên và hàm răng trên nhô ra. Be ngoài như thế khiến cô luôn là mục tiêu dễ dàng cho những tiếng cười khúc khích và những câu đùa ác nghiệt của lũ học trò.\n" +
                    "\n" +
                    "Cô cũng hay làm cho các học sinh bực bội vì những yêu cầu khắt khe của mình. Hầu hết chúng tôi đều xem nhẹ năng lực của cô.\n" +
                    "\n" +
                    "- Phải. Tất cả các em phải suy nghĩ về nghề nghiệp trong tương lai của mình. - Cô hăng hái nói như thể đây là điều tuyệt nhất mà cô làm được cho học sinh của mình. - Các em sẽ phải làm một đề tài nghiên cứu về nghề nghiệp trong tương lai của mình. Mỗi em sẽ phải phỏng vấn một ai đó làm trong lĩnh vực mà mình chọn, rồi thuyết trình trước lớp.\n" +
                    "\n" +
                    "Hôm đó, tất cả chúng tôi đều tan học với sự lúng túng. Có ai mà biết mình muốn làm gì khi mới 13 tuổi chứ? Tuy nhiên, tôi đã thu hẹp những lựa chọn của mình lại. Tôi thích nghệ thuật, ca hát và viết văn. Nhưng về nghệ thuật thì tôi rất tệ, còn khi tôi hát các chị tôi hay hét lên: “Này, làm ơn ngậm miệng lại dùm đi”. Lựa chọn duy nhất còn lại là viết văn.\n" +
                    "\n" +
                    "Và trong những giờ lên lớp kế tiếp của mình, cô Deview đều kiểm tra chúng tôi: “Chúng tôi đã đi đâu?”, “Các bạn nào đã chọn được nghề nghiệp cho mình?”. Cuối cùng, hầu hết chúng tôi đều đã chọn được một nghề nào đó; tôi đã chọn nghề làm báo. Điều đó có nghĩa là tôi phải đi phỏng vấn một phóng viên báo chí bằng xương bằng thịt. Điều này làm tôi rất lo.\n" +
                    "\n" +
                    "Tôi ngồi xuống trước mặt người phóng viên mà tôi gặp gần như không thể nói nổi lời nào. Ông ấy nhìn tôi rồi hỏi:\n" +
                    "\n" +
                    "- Cháu có mang theo cây viết nào không?\n" +
                    "\n" +
                    "Tôi lắc đầu.\n" +
                    "\n" +
                    "- Còn giấy viết thì sao?\n" +
                    "\n" +
                    "Tôi lại lắc đầu.\n" +
                    "\n" +
                    "Cuối cùng, chắc ông ấy nhận ra là tôi đang sợ hãi và đã cho tôi một lời khuyên hữu ích đầu tiên để có thể trở thành một nhà báo.\n" +
                    "\n" +
                    "- Bác chưa bao giờ đi đến bất kỳ nơi nào mà không mang theo bút và giấy viết cả, bởi vì ta chẳng bao giờ biết mình đang rơi vào chỗ nào.\n" +
                    "\n" +
                    "Trong 90 phút tiếp đó, người phóng viên đứng tuổi đã kể cho tôi nghe toàn những câu chuyện về các vụ cưóp, những trường hợp ăn chơi sa đọa và những vụ hỏa hoạn, ông kể về một đám cháy bi thảm đã cưóp đi sinh mạng của bốn người trong gia đình nọ mà ông không thể nào quên, ông bảo rằng ông vẫn có thể ngửi thấy mùi thịt của họ đang cháy...\n" +
                    "\n" +
                    "Vài ngày sau, tôi đã trình bày bài thuyết trình về nghề nghiệp của mình trước lớp hoàn toàn bằng trí nhớ một cách say sưa như bị thôi miên. Tôi nhận được điểm A cho toàn bộ công trình của mình.\n" +
                    "\n" +
                    "Khi năm học sắp kết thúc, một vài học sinh quá bất mãn đã quyết định trả thù cô Virginia Deview vì công việc khó khăn mà cô đã bắt chúng tôi làm. Khi cô đi đến một góc hành lang nọ, chúng đã cố hết sức ấn mạnh một cái bánh vào mặt cô. Cô chỉ bị xây xát nhẹ bên ngoài, nhưng trong lòng cô đã bị tổn thương rất nặng. Nhiều ngày sau đó, cô đã không đến trường. Khi tôi nghe được chuyện ấy, ruột tôi như bị ai cắt. Tôi cảm thấy xấu hổ cho chính mình và những đứa bạn của tôi, những người không biết làm điều gì tốt hơn là lên án một người phụ nữ vì vẻ bề ngoài của cô ấy, thay vì thán phục những phương pháp giảng dạy thú vị của cô.\n" +
                    "\n" +
                    "Nhiều năm sau, tôi đã quên tất cả mọi chuyện về cô Deview cũng như những nghề nghiệp chúng tôi đã lựa chọn. Tôi vào đại học và tìm kiếm một nghề nghiệp mới. Cha muốn tôi đi theo lĩnh vực kinh doanh và dường như đó là một lời khuyên đúng đắn vào lúc bấy giờ, nhưng oái oăm thay tôi chẳng có lấy một ký năng kinh doanh nào. Thế rồi tôi chợt nhớ đến cô Virginia Deview cùng ước muốn làm phóng viên hồi 13 tuổi. Tôi gọi điện cho ba mẹ.\n" +
                    "\n" +
                    "- Con sẽ đổi nghề - Tôi thông báo.\n" +
                    "\n" +
                    "Một sự im lặng nặng nề ở đầu dây điện thoại bên kia.\n" +
                    "\n" +
                    "- Đổi sang nghề gì? - Cuối cùng cha tôi cất tiếng.\n" +
                    "\n" +
                    "- Nghề làm báo ạ!\n" +
                    "\n" +
                    "Tôi có thể đọc thấy sự không vui qua giọng nói của ba mẹ, nhưng họ không ngăn cản tôi. Họ chỉ nhắc nhở tôi rằng đây là một lĩnh vực đầy cạnh tranh và tôi đã muốn tránh nó như thế nào.\n" +
                    "\n" +
                    "Họ nói đúng. Tuy nhiên nghề phóng viên báo chí đã đem lại cho tôi điều gì đó; nó nằm trong máu thịt của tôi. Nó đem đến cho tôi sự tự do để đến được với tất cả những người xa lạ và hỏi họ về những điều đã xảy ra. Nó luyện cho tôi cách đặt câu hỏi và tìm được câu trả lời trong cả nghề nghiệp lẫn cuộc sống riêng tư của mình. Nó mang đến cho tôi sự tự tin.\n" +
                    "\n" +
                    "Trong 12 năm qua, nghề phóng viên đem lại cho tôi Sự hài lòng và rất nhiều điều ngạc nhiên thú vị. Tôi viết mọi chuyện từ những kẻ giết người đến những vụ rơi máy bay và sau cùng là viết theo sở trường của mình. Tôi thích viết về những giây phút bi thảm và mong manh trong cuộc sống con người, bởi lẽ tôi cảm thấy điều đó giúp họ trong một phương diện nào đó.\n" +
                    "\n" +
                    "Một ngày nọ, khi tôi nhắc điện thoại lên, một cơn sóng ký niệm chợt ùa về trong tôi. Tôi nhận ra rằng nếu không có sự ủng hộ của cô Virginia De view, tôi sẽ không có được vị trí hiện nay của mình.\n" +
                    "\n" +
                    "Có lẽ cô sẽ chẳng bao giờ biết được nếu không có sự giúp đỡ của cô, tôi đã không trở thành một phóng viên và một nhà văn. Có thể tôi đang ngụp lặn trong thế giới kinh doanh ở một nơi nào đó, với những rủi ro to lớn bao vây lấy tôi mỗi ngày. Tôi tự hỏi giờ đây có bao nhiêu học sinh khác đã từng là học trò của cô nhận thức được tầm quan trọng của bài tập nghiên cứu về nghề nghiệp đó.\n" +
                    "\n" +
                    "Người ta luôn hỏi rằng:\n" +
                    "\n" +
                    "- Anh đã chọn nghề báo như thế nào?\n" +
                    "\n" +
                    "- À, anh có biết không, có một cô giáo...\n" +
                    "\n" +
                    "Tôi luôn bắt đầu như thế và thầm cám ơn cô Deview.\n" +
                    "\n" +
                    "Tôi mong rằng những học trò của cô khi ngẫm nghĩ về những ngày còn đi học của mình, sẽ còn giữ lại trong tâm trí hình ảnh của một người giáo viên độc thân - cô Virginia Deview - rất riêng, rất khác biệt của họ. Có lẽ họ sẽ cám ơn cô ấy trước khi quá trễ.',7,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đêm cuối cùng','Hãy dành thời gian cho mọi người quanh mình - cho dù đó là một việc nhỏ nhoi. Hãy làm điều mà bạn chẳng được hưởng lợi lộc gì ngoài đặc quyền làm điều đó.\n" +
                    "\n" +
                    "- Albert Schweitzer\n" +
                    "\n" +
                    "Cụ ơi, con trai cụ đến rồi đây. - Cô y tá khẽ gọi cụ già.\n" +
                    "\n" +
                    "Phải gọi đến mấy lần ông lão mới khó nhọc mở mắt ra. Đêm qua, ông được đưa vào bệnh viện trong tình trạng hôn mê do trụy tim và sau khi cấp cứu, ông cũng chỉ tỉnh lại phần nào. Ông loáng thoáng nhìn thấy bóng dáng một thanh niên trong bộ quân phục lính thủy đang đứng cạnh giường mình.\n" +
                    "\n" +
                    "Ông lão đưa tay ra cầm lấy tay chàng trai. Những ngón tay rắn rỏi của anh lính siết nhẹ bàn tay mềm rũ không còn chút sinh khí ấy. Cô y tá mang đến một chiếc ghế để người lính ngồi với cha mình.\n" +
                    "\n" +
                    "Suốt đêm, anh lẳng lặng ngồi trong căn phòng ánh sáng tù mù, nắm tay ông lão và nói với ông những lời động viên, ông lão hấp hối nằm yên, không nói gì, nhưng tay ông vẫn không rời bàn tay chàng trai. Mặc những tiếng rì rì của bình ôxy, tiếng rên rỉ của các bệnh nhân khác và tiếng bước chân của các y tá trực đêm ra vào phòng, anh lính vẫn ngồi ngay ngắn bên ông lão.\n" +
                    "\n" +
                    "Cô y tá, thỉnh thoảng ghé vào thăm nom các bệnh nhân, luôn bắt gặp anh lính trẻ thì thầm những lời an ủi vào tai ông. Nhiều lần, cô chủ ý nhắc anh chợp mắt một lát, nhưng anh đều từ chối.\n" +
                    "\n" +
                    "Gần sáng, ông lão trút hơi thở cuối cùng. Người lính cẩn thận đặt bàn tay lạnh lẽo của ông lên giường và bước ra ngoài tìm cô y tá. Anh ngồi đợi trong lúc cô chuyển thi hài ông lão xuống nhà xác và làm những thủ tục cần thiết. Khi quay lại, cô y tá ngỏ lời chia buồn với anh, nhưng khi cô chưa dứt lời, anh đã ngắt ngang hỏi:\n" +
                    "\n" +
                    "- Ông cụ này là ai vậy?\n" +
                    "\n" +
                    "Cô y tá giật mình.\n" +
                    "\n" +
                    "- Ông cụ là cha anh mà!\n" +
                    "\n" +
                    "- Không phải đâu. Ông cụ ấy đâu phải là cha tôi. Tôi chưa gặp ông bao giờ cả.\n" +
                    "\n" +
                    "- Vậy sao anh không nói khi tôi đưa anh đến gặp ông?\n" +
                    "\n" +
                    "- Tôi biết là có sự nhầm lẫn từ người cấp phép cho tôi về nhà. Tôi nghĩ có lẽ con trai ông cụ và tôi trùng tên, trùng quê quán và có số quân giống nhau, do đó người ta mới nhầm như vậy. - Người lính giải thích. - Ông cụ rất muốn gặp con trai mình mà anh ấy lại không có mặt ở đây. Khi đến bên ông cụ tôi nhận ra là cụ đã yếu đến mức không còn phân biệt được tôi với con trai cụ nữa. Biết là ông rất cần có ai đó bên cạnh, nên tôi đã quyết định ở lại',8,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Quà sinh nhật','Tôi ước ao có một ngày bốn đứa con của tôi sẽ được sống trên một đất nước không có ai bị phán xét bởi màu da của mình mà bởi chính tâm hồn của người ấy.\n" +
                    "\n" +
                    "- Martin Luther King Jr.\n" +
                    "\n" +
                    "[Chú thích: Câu chuyện này được viết vào năm 1969 khi mà nạn phần biệt chúng tộc ở Mỹ chưa được cải thiện. ]\n" +
                    "\n" +
                    "Sau khi con trai tôi học lớp một được một tuần, thằng bé về nhà báo tin rằng Roger, học sinh người Mỹ gốc Phi duy nhất trong lớp, là bạn ngoài sân chơi của nó. Tôi nuốt nước bọt rồi nói:\n" +
                    "\n" +
                    "- Hay nhỉ! Thế con sẽ chơi chung với nó bao lâu nữa thì có đứa khác thay con chơi với nó?\n" +
                    "\n" +
                    "- Ô, con sẽ chơi với bạn ấy mãi mãi mẹ ạ!- Mike trả lời tôi.\n" +
                    "\n" +
                    "Rồi một tuần sau, tôi lại nghe tin Mike rủ Roger ngồi chung bàn học với mình.\n" +
                    "\n" +
                    "Nếu như bạn không sinh ra và lớn lên ở tận miền nam nước Mỹ xa xôi này, như tôi đây, thì bạn sẽ không thể nào hiểu được những tin này khủng khiếp như thế nào. Tôi lập tức hẹn gặp giáo viên dạy lớp con tôi.\n" +
                    "\n" +
                    "Cô giáo đón tôi với đôi mắt mệt mỏi và đầy hoài nghi. Cô nói:\n" +
                    "\n" +
                    "- Thưa bà, tôi cho là bà cũng muốn con trai mình được ngồi chung với một học sinh khác, phải không ạ? Bà vui lòng chờ cho một lát. Tôi cũng có một cuộc hẹn với một phụ huynh khác và bà ấy đang đến kìa.\n" +
                    "\n" +
                    "Vừa lúc ấy, tôi trông thấy một phụ nữ trạc tuổi tôi bước tới. Tim tôi tự nhiên đập mạnh bởi tôi đoán chắc bà ấy là mẹ của Roger. Nơi bà toát lên vẻ trầm lặng và hết sức đĩnh đạc của một người phụ nữ có phẩm cách, nhưng những điều đó cũng không giúp bà ta giấu được nỗi lo lắng thể hiện qua giọng nói:\n" +
                    "\n" +
                    "- Cháu Roger thế nào rồi, thưa cô? Tôi mong rằng con tôi vẫn quan hệ tốt với những đứa trẻ khác. Nếu không như thế, cô cho tôi biết nhé!\n" +
                    "\n" +
                    "Bà ngập ngừng khi tự nêu câu hỏi:\n" +
                    "\n" +
                    "- Cháu có làm điều gì khiến cô phải phiền lòng không? Ý tôi nói là việc cháu phải thay đổi chỗ ngồi quá nhiều lần!\n" +
                    "\n" +
                    "Tôi cảm nhận được sự căng thẳng tột độ trong lòng mẹ của Roger, vì chắc bà đã biết rõ câu trả lời. Nhưng tôi thấy tự hào cho cô giáo lớp một này khi nghe cô dịu dàng đáp:\n" +
                    "\n" +
                    "- Không có đâu, thưa bà! Cháu Roger không làm gì để tôi phải phiền lòng cả. Chẳng qua trong những tuần đầu tiên, tôi cố gắng chuyển đổi chỗ ngồi để cuối cùng em nào cũng tìm được người bạn hợp với mình thôi.\n" +
                    "\n" +
                    "Bấy giờ tôi mới giới thiệu mình và nói rằng con trai tôi là bạn cùng bàn mới của Roger và tôi hy vọng hai đứa nó sẽ thương mến nhau. Ngay lúc nói ra tôi đã biết những lời của mình hoàn toàn sáo rỗng, chứ tận đáy lòng, tôi thực sự không muốn điều này. Nhưng rõ ràng là câu nói ấy đã làm yên lòng mẹ của Roger.\n" +
                    "\n" +
                    "Đã hai lần thằng bé Roger mời Mike đến nhà mình chơi, nhưng lần nào tôi cũng viện lý do để không cho con tôi đi. Và rồi có một việc xảy ra khiến cho lòng tôi cứ day dứt mãi không thôi khi nghĩ lại cách cư xử của mình.\n" +
                    "\n" +
                    "Vào ngày sinh nhật của tôi, Mike đi học về cầm trên tay một tờ giấy lấm lem được gấp lại vuông vức. Tôi mở ra và nhìn thấy ba bông hoa và dòng chữ “Chúc mừng sinh nhật Cô!” được viết nắn nót bằng bút chì ở mặt trong tờ giấy và một đồng cắc năm xu.\n" +
                    "\n" +
                    "- Roger gửi tặng mẹ đó! - Mike nói - Đó là tiền mua sữa của bạn ấy. Khi con nói hôm nay là sinh nhật của mẹ, bạn ấy nhờ con mang về tặng mẹ. Bạn Roger nói rằng mẹ cũng là mẹ của bạn ấy, vì mẹ là người mẹ duy nhất đã không yêu cầu bạn ấy phải đổi sang bàn khác.',9,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bàn tay cô giáo','Bạn không bao giờ biết được niềm hạnh phúc mà một hành động tứ tế đơn giản mang đến sẽ như thế nào đâu.\n" +
                    "\n" +
                    "- Bree Abel\n" +
                    "\n" +
                    "Trong ngày lễ Tạ ơn, một cô giáo dạy lớp một nọ đã bảo những học sinh của mình vẽ một bức tranh về điều gì đó mà các em biết ơn. Cô muốn biết xem những đứa trẻ từ các vùng phụ cận nghèo nàn này thật sự mang ơn ra sao. Tuy nhiên cô nghĩ rằng hầu hết các học sinh của cô sẽ vẽ những bức tranh về gà tây hay những chiếc bàn đầy thức ăn. Nhưng cô đã sửng sốt với bức tranh của bé Douglas, bức tranh một bàn tay được vẽ bằng nét trẻ thơ rất đơn giản.\n" +
                    "\n" +
                    "Nhưng bàn tay đó là của ai? Cả lớp đều bị cuốn hút với hình ảnh trừu tượng đó.\n" +
                    "\n" +
                    "- Em nghĩ đó chắc là bàn tay của Chúa mang thức ăn đến cho chúng ta - Một em nói.\n" +
                    "\n" +
                    "- Của một người nông dân, - một em khác lên tiếng, - bởi vì ông ta nuôi gà tây.\n" +
                    "\n" +
                    "Cuối cùng khi những em khác đang làm bài, cô giáo đến bên bàn Douglas và hỏi cậu bé bàn tay đó là của ai.\n" +
                    "\n" +
                    "- Đó là bàn tay cô, thưa cô. - Em thầm thì.\n" +
                    "\n" +
                    "Cô nhớ lại rằng vào giờ giải lao, cô thường hay dắt tayDouglas, một đứa bé cô độc ít nói. Cô cũng thường làm thế với những bạn khác nhưng với Douglas điều đó có ý nghĩa rất lớn. Có lẽ đây là lễ Tạ ơn dành cho mọi người, không phải cho những vật chất mà chúng ta nhận được, mà là cho những điều, dù rất nhỏ nhoi khi ta trao tặng cho người khác.\n" +
                    "\n" +
                    "Tất cả mọi người trên trái đất này đều được sinh ra với một thảm kịch - đó là chúng ta cần phải lớn lên. Rất nhiều người không có dũng khí làm điều đó.\n" +
                    "\n" +
                    "- Helen Hayes',10,5)");
            db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Ước mơ bé bỏng','Khát vọng sâu thẳm nhất trong bản chất của con người là lòng khao khát được đánh giá và công nhận đúng đắn.\n" +
                    "\n" +
                    "- William James\n" +
                    "\n" +
                    "Vừa bước ra khỏi lớp và rẽ vào dãy hành lang chính, Amy Hagadorn đã va phải một học sinh lớp năm cao lớn đang chạy đến từ hưóng ngược lại.\n" +
                    "\n" +
                    "- Coi chừng mày đó oắt con.\n" +
                    "\n" +
                    "Cậu ta nạt nộ cô học sinh lớp ba này, rồi lách vòng qua người cô bé. Ke đó cậu ta nhe răng cười khoái trá khi lấy tay ôm chân phải của mình rồi bắt chước bước đi cà nhắc của Amy. Amy nhắm mắt lại một lúc: “Không thèm chấp”, em tự nhủ rồi đi về lớp học. Ây vậy mà cho đến cuối ngày hôm đó, tâm trí Amy vẫn không quên cử chỉ chế nhạo của cậu học sinh lúc sáng. Và cậu ta cũng không phải là người duy nhất làm thế với em. Ngay từ đầu năm học đến giờ, ngày nào cũng có bạn chọc ghẹo Amy, lúc thì nhại giọng nói của Amy, lúc thì bắt chước dáng đi khó nhọc của em. Lớp của em đông vui lắm nhưng những lời chọc ghẹo đó khiến Amy cảm thấy lạc lõng vô cùng.\n" +
                    "\n" +
                    "Bữa cơm tối hôm đó, Amy lặng lẽ ăn mà không nói một lời nào. Biết con mình đã gặp chuyện không vui ở trường, bà Patty Hagadorn tằng hắng rồi lên giọng vui đùa thông báo một tin sốt dẻo.\n" +
                    "\n" +
                    "- Đài phát thanh địa phương năm nay có mở một cuộc thi viết về điều ước Giáng Sinh. Các bạn hãy mau mau viết thư gỏi cho ông già Noel và biết đâu bạn sẽ là người thắng cuộc. Mẹ nghĩ rằng cô bé có mái tóc xoăn màu vàng hung đang ngồi ở bàn nên tham gia ngay thôi!\n" +
                    "\n" +
                    "Amy khúc khích cười và không đợi mẹ giục lần thứ hai, em lấy giấy bút ra. Em đặt bút viết dòng chữ đầu tiên: “Thưa ông già Noel”.\n" +
                    "\n" +
                    "Trong khi em nắn nót viết, mọi người trong nhà cố đoán xem Amy đang cầu xin ông già Noel điều gì. Chị gái Jamie và mẹ em đều nghĩ rằng con búp bê Barbie thật lớn sẽ là ưu tiên số một trong danh sách lời ước của em. Còn bố của Amy thì đoán đó là một quyển truyện tranh. Tuy nhiên, Amy không hề hé cho ai biết lời ước của mình.\n" +
                    "\n" +
                    "Tại đài phát thanh của thị trấn Fort Wayne, bang Indiana, những lá thư của các em nhỏ ào ạt gửi đến dự thi. Các nhân viên đã liệt kê được rất nhiều món quà khác nhau mà các bé trai bé gái ở khắp nơi trong thành phố ước ao nhận được trong ngày Giáng Sinh. Khi đến lá thư của Amy, giám đốc Lee Tobin đã đọc đi đọc lại nó rất cẩn thận:\n" +
                    "\n" +
                    "“Thưa ông già Noel!\n" +
                    "\n" +
                    "Con tên là Amy, năm nay con chín tuổi. Con có một chuyện rắc rối ở trường học, không biết ông có thể giúp con được không? Các bạn cười nhạo con vì dáng con đi, cách con chạy và giọng con nói. Con bị bệnh bại não. Con chỉ xin ông cho con có được một ngày không bị ai đó cười nhạo và chế giễu con.\n" +
                    "\n" +
                    "Thân ái,\n" +
                    "\n" +
                    "Amy”\n" +
                    "\n" +
                    "Trái tim Lee Tobin đau nhói khi ông đọc lá thư ấy. Ông biết bại não là căn bệnh làm rối loạn cơ bắp mà có lẽ đã khiến các bạn học cùng trường với Amy có những suy nghĩ không hay. Ông nghĩ rằng tốt hơn nên để người dân ở Fort Wayne được biết về cô bé đặc biệt này cùng lời ước khác thường của em. Nghĩ vậy ông Tobin gọi điện thoại đến tòa soạn của tờ nhật báo trong vùng.\n" +
                    "\n" +
                    "Ngày hôm sau, hình ảnh của Amy và lá thư em gửi cho ông già Noel xuất hiện ngay trên trang nhất tờ News Sentinel. Câu chuyện về em được lan truyền nhanh chóng. Khắp nước Mỹ, báo chí, đài phát thanh và đài truyền hình đồng loạt đưa tin về câu chuyện của bé gái ở Fort Wayne, Indiana, người chỉ xin một món quà Giáng Sinh giản dị mà rất ấn tượng: một ngày không bị ai chế giễu.\n" +
                    "\n" +
                    "Thật bất ngờ, những ngày sau đó gia đình Hagadorn đã liên tục nhận được rất nhiều thư của trẻ em cũng như người lớn từ khắp nơi trong nước gửi đến cho Amy, rất nhiều thiệp chúc mừng Giáng Sinh và những lời động viên. Trong suốt mùa Giáng Sinh bận rộn đó, những cánh thư ấm tình bạn bè và chia sẻ của hơn hai ngàn người trên khắp thế giới đã gỏi đến cho Amy. Trong số đó, có người bị khuyết tật, có người cũng từng bị chế giễu khi còn bé, nhưng mỗi người đều dành cho Amy một thông điệp đặc biệt. Qua những lá thư và cánh thiệp từ những người không quen không biết ấy, Amy thoáng thấy một thế giới đầy ắp những con người thực sự quan tâm đến nhau. Và em nhận ra rằng không còn một hình thức nhạo báng nào và không một gánh nặng chế giễu nào có thể làm cho em cảm thấy cô độc nữa.\n" +
                    "\n" +
                    "Nhiều người cám ơn Amy vì đã can đảm lên tiếng. Những người khác khuyến khích em đừng để tâm đến sự giễu cợt và hãy ngẩng cao đầu. Lynn, một học sinh lớp 6 ở Texas đã viết cho Amy:\n" +
                    "\n" +
                    "“Mình muốn kết bạn với đằng ấy. Mình nghĩ nếu bạn đến thăm mình thì chúng ta sẽ rất vui đấy! Sẽ không ai nhạo báng bọn mình, vì nếu họ làm thế, chúng ta chẳng thèm nghe. “\n" +
                    "\n" +
                    "Amy đã đạt được điều ước của mình - một ngày không bị ai chế giễu ở trường tiểu học South Wayne. Các giáo viên và học sinh trong trường còn đi xa hơn nữa, bằng cách cùng thảo luận với nhau về hành vi chế nhạo sẽ làm cho người khác cảm thấy như thế nào. Năm đó, thị trưởng của Fort Wayne chính thức tuyên bố rằng ngày 21 tháng 12 sẽ trở thành “Ngày của Amy Hagadorn”. Viên thị trưởng giải thích rằng việc mạnh dạn ước xin một điều giản dị như thế, Amy đã nêu một tấm gương cho tất cả mọi người.\n" +
                    "\n" +
                    "- Mọi người, - ông thị trưởng nói, - ai cũng muốn được đối xử một cách trân trọng, đúng đắn và nồng ấm, và họ xứng đáng được nhận tất cả những điều đó.',11,5)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Người phụ nữ nhân hậu','Tình yêu mà chúng ta cho đi là tình yêu duy nhất chúng ta giữ được.\n" +
                "\n" +
                "- Elbert Hubbard\n" +
                "\n" +
                "Nếu bạn đã có lần viếng thăm thành phố New Orleans xinh đẹp, chắc hẳn sẽ có ai đó hướng dẫn bạn đến khu kinh doanh lâu đời của thành phố này, nơi tập trung các ngân hàng, cửa hiệu, khách sạn và sẽ chỉ cho bạn thấy một pho tượng được dựng vào năm 1884, đứng sừng sững tại quảng trường nhỏ ở đây. Pho tượng tạc hình một người phụ nữ đang ngồi trên cái ghế thấp, tay ôm một đứa bé đang ngả đầu vào người bà. Người phụ nữ không mấy xinh đẹp và trang phục của bà khá giản dị. Bà mang một đôi giày vải, mặc váy trơn, trên vai quàng một cái khăn và đội một cái mũ rộng vành trên đầu. Bà có dáng người tầm thước, trông hơi mập. Khuôn mặt bà có nét điển hình của người Ái Nhĩ Lan với chiếc cằm vuông vức. Ánh mắt của bà thật đặc biệt, chúng nhìn bạn một cách nồng ấm, chứa chan tình cảm tựa như ánh mắt của một người mẹ dành cho đứa con thân yêu của mình.\n" +
                "\n" +
                "Có một số điều đáng ngạc nhiên về bức tượng này. Đó là một trong những pho tượng đầu tiên ở Mỹ được tạc để tôn vinh một người phụ nữ. Ngay cả tại châu Âu cổ xưa, có rất ít tượng đài được xây dimg để tỏ lòng tôn vinh phụ nữ, và nếu có, hầu hết chúng đều dành cho những nữ hoàng hoặc công nướng quyền quý, những người rất xinh đẹp và rất sang trọng. Nhưng pho tượng ở New Orleansnày thì hoàn toàn khác.\n" +
                "\n" +
                "Pho tượng này thuộc về bà Margaret Haughery, nhưng chẳng ai tại New Orleans nhớ rõ cái tên đó. Họ chỉ nhớ bà là Margaret. Và đây là câu chuyện về bà Margaret và lý do tại sao người ta phải dựng tượng để tưởng niệm bà.\n" +
                "\n" +
                "Margaret mồ côi cả cha lẫn mẹ khi còn rất nhỏ. Bà được một cặp vợ chồng trẻ nhận làm con nuôi. Họ cũng nghèo khó và tử tế như cha mẹ ruột của bà. Margaret sống với họ đến lúc trưởng thành, lập gia đình và sinh một con trai. Nhưng không may, chẳng bao lâu sau chồng, rồi con bà lần lượt qua đời, để lại mình Margaret quạnh hiu. Tuy nghèo nhưng Margaret khỏe mạnh và giỏi giang. Bà không để đau buồn quật ngã, bà vẫn tiếp tục làm việc.\n" +
                "\n" +
                "Bà ủi quần áo cho một tiệm giặt ủi suốt ngày từ sáng sớm đến tối mịt. Và mỗi ngày, qua song cửa sổ nơi làm việc, bà trông thấy những đứa trẻ ở trại mồ côi gần đó làm việc và chơi đùa. Một thời gian sau, một trận đại dịch xuất hiện ở thành phố, cưóp đi bao sinh mạng và làm cho số trẻ côi cút tăng lên. Trại mồ côi không đủ chỗ để chăm sóc các em, còn các em thì đang cần một chỗ dựa. Chắc hẳn không ai có thể nghĩ rằng một người phụ nữ nghèo hèn, sống bằng nghề giặt ủi, lại có thể trở thành một chỗ dựa thân ái mà các em bé bơ vơ đang cần đến. Nhưng Margaret đã nghĩ như vậy.\n" +
                "\n" +
                "Bà đến thẳng trại mồ côi, nói rằng bà sẽ trích một phần lương của mình tặng cho trại và ngoài ra bà còn tình nguyện sống bên cạnh để chăm sóc các em.\n" +
                "\n" +
                "Bà cố gắng làm việc chăm chỉ, và chẳng mấy chốc, từ số tiền lương dành dụm được, bà mua một cặp bò và một chiếc xe chở hàng nhỏ. Mỗi sáng, bà đánh xe đi giao sữa cho khách hàng và không quên xin những thức ăn còn thừa từ các khách sạn và những nhà giàu có trong thành phố về cho lũ trẻ đói lòng trong trại mồ côi. Vào những lúc khó khăn nhất, nhiều khi chính số thức ăn thừa thãi đó đã giúp các em ấm bụng.\n" +
                "\n" +
                "Với khoản tiền bà Margaret kiếm được, mỗi tuần bà trích một phần mang đến tặng trại trẻ mồ côi. Sau vài năm số tiền ấy ngày một lớn. Do tính cẩn thận và giỏi giang, công việc kinh doanh của bà ngày thêm phát triển. Và dù vẫn cho đi, Margaret vẫn kiếm được nhiều tiền hơn và mua thêm nhiều bò. Cuối cùng, bằng số tiền tích lũy, bà xây một ngôi nhà dành cho trẻ em mồ côi.\n" +
                "\n" +
                "Một thời gian sau, Margaret mua được một lò làm bánh mì, rồi bà chuyển sang nghề giao bánh mì. Và những đồng tiền kiếm được, bà vẫn đều đặn trích ra tặng cho trại mồ côi.\n" +
                "\n" +
                "Rồi Cuộc nội chiến ở Mỹ bùng nổ. Trong thời buổi loạn ly, bệnh tật và đầy sợ hãi ấy, Margaret vẫn đánh chiếc xe bò đi giao bánh mì. Bà luôn xoay xở để vừa giúp đỡ những người lính đói khát, vừa quan tâm đến những em bé mồ côi. Dẫu vậy, khi chiến tranh kết thúc bà cũng có đủ tiền xây một lò bánh mì lớn. Đến lúc này, không ai trong thành phố không biết đến tên bà. Trẻ em trong khắp thành phố yêu quý bà. Các doanh nhân tự hào về bà. Những người nghèo đến gặp bà xin lời khuyên bảo. Bà thường ngồi trước cửa văn phòng mình, trong bộ váy bằng vải dày và với cái khăn nhỏ quàng trên cổ, tận tình đưa ra lời khuyên cho tất cả những ai đến nhờ bà giúp đỡ, bất kể họ giàu hay nghèo.\n" +
                "\n" +
                "Cuộc sống dần trồi cho đến một ngày, bà Margaret lặng lẽ qua đời. Lúc đọc di chúc của bà, người ta mới biết ngoài tất cả những gì bà đã hiến tặng, bà vẫn còn dành dụm được 30.000 đô la - một số tiền không nhỏ - và bà muốn tặng hết số tiền này cho tất cả các trại mồ côi trong thành phố, không phần biệt là trại của người da trắng, da đen, người Do Thái, người theo đạo Thiên Chúa hay đạo Tin Lành. Margaret luôn nói “Tất cả đều là trẻ mồ côi như nhau”. Và bạn biết không, những ý nguyện cao đẹp của bà đã được ký bằng một nét gạch ngang thay cho tên của bà, vì Margaret chưa bao giờ biết đọc hay biết viết!\n" +
                "\n" +
                "Khi hay tin bà qua đời, người dân New Orleans đã truyền tụng về bà rằng “bà là mẹ của tất cả những người mồ côi mẹ, là bạn của những người không có bạn bè. Sự thông tuệ của bà không trường học nào có thể dạy được. Chúng ta sẽ mãi mãi không được quên bà ấy”. Thế là họ tạc một bức tượng mang đậm những nét quen thuộc về bà đã để lại trong tâm trí mỗi người, lúc bà đang ngồi trước văn phòng riêng hoặc đánh chiếc xe bò đi chở hàng. Và ngày nay, pho tượng vẫn sừng sững ở đó, ngay giữa thành phố đông đúc người qua lại, thể hiện tấm lòng kính trọng của người dân New Orleans đối với người phụ nữ có trái tim vô cùng nhân hậu và cách sống giản dị tên là Margaret Haughery.',1,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Sự lựa chọn của mẹ','Lạc quan là tâm trạng có thể khiến cho ấm trà cất tiếng hát dù nước trong bụng nó đang nóng rực.\n" +
                "\n" +
                "- Ngạn ngữ Nga\n" +
                "\n" +
                "Ngay từ nhỏ, tôi hay thầm ganh tị với vẻ đẹp của mẹ và những gì mẹ đạt được. Nhưng khi mẹ bị liệt ở tuổi 31 do u xương sống, thì cuộc đời chúng tôi đã thay đổi hẳn - lúc ấy tôi mới tròn 10 tuổi. Dường như chỉ qua một đêm thôi, sáng dậy mẹ thấy mình bất động trên giường. Còn tôi thì còn quá trẻ con nên không thể hiểu hết cái nghĩa mỉa mai của từ “khối u lành tính”, nhưng chẳng lành tính chút nào đối với mẹ tôi.\n" +
                "\n" +
                "Trước đó, mẹ rất vui vẻ, thích giao du và thường mời khách đến nhà chơi. Mẹ cất công hàng giờ làm món thịt nguội và bày biện hoa tươi. Rồi trong lúc mọi người khiêu vũ rộn rằng thì mẹ lại tất bật lo sắp xếp chỗ ngủ cho những người bạn phương xa. Mà mẹ thích khiêu vũ lắm. Đến giờ, tôi vẫn nhớ bộ đồ dạ hội tuyệt vời của mẹ - váy đen và chiếc áo buộc dây làm nổi bật mái tóc vàng óng ả. Ngày mẹ đem về đôi giày gót cao màu đen, tôi cũng hồi hộp chẳng kém gì mẹ. \n" +
                "\n" +
                "Tối đó, tôi không nói quá, mẹ là người phụ nữ đẹp nhất trên đời.\n" +
                "\n" +
                "Tôi tin thứ gì mẹ cũng biết làm: chơi tennis (mẹ từng giành giải thưởng hồi học đại học), may vá (mẹ tự may tất cả quần áo cho chúng tôi), chụp hình (mẹ đã từng thắng ở cuộc thi quốc gia), viết lách (mẹ phụ trách một mục trên báo) và nấu nướng (đặc biệt là những món Tây Ban Nha cho cha).\n" +
                "\n" +
                "Giờ đây, khi không thể làm những việc ấy nữa, mẹ đối mặt với bệnh tật cùng với lòng quả cảm và quyết tâm tương tự.\n" +
                "\n" +
                "Những từ “tàn tật”, “vật lý trị liệu” đã trở thành một phần của thế giới mới, xa lạ mà chúng tôi vừa bước vào. Dần dần, tôi đã học cách chăm sóc mẹ, thay vì được mẹ chăm sóc. Rồi việc đẩy xe lăn đưa mẹ vào bếp đã thành thông lệ. Mẹ chỉ cho tôi nghệ thuật tỉa cà rốt, khoai tây và cách nhào tẩm miếng thịt bò nướng với tỏi tươi, muối và bơ sao cho ngon.\n" +
                "\n" +
                "Lần đầu tiên nghe nói đến cây gậy, tôi liền phản đối:\n" +
                "\n" +
                "- Con không muốn người mẹ xinh đẹp của mình dùng gậy đâu!\n" +
                "\n" +
                "Mẹ chỉ nhẹ nhàng bảo:\n" +
                "\n" +
                "- Thế con thích mẹ đi bằng gậy hay không bao giờ đi nào?\n" +
                "\n" +
                "Mỗi thành tích mẹ đạt được là một sự kiện đáng nhớ cho cả hai chúng tôi: nào sử dụng được máy đánh chữ bằng điện, lái xe có thiết bị tự động và lấy bằng thạc sĩ qua một chương trình đặc biệt.\n" +
                "\n" +
                "Mẹ tìm hiểu tất cả mọi thứ về người khuyết tật và chính mẹ lập ra nhóm hỗ trợ mang tên Gia Đình Khuyết Tật. Một ngày nọ, mẹ đưa tôi và các anh đến cuộc họp mặt của hội. Chưa bao giờ tôi thấy đông người khuyết tật đến thế. Trở về, tôi trở nên trầm tư, cảm thấy mình vẫn còn may mắn. Nhiều người có tình cảnh rất thương tâm. Mẹ còn dẫn chúng tôi đến gặp những người bại não - chúng tôi không còn bị sốc nữa. Mẹ dạy chúng tôi cách giao tiếp với những người chậm phát triển trí tuệ. Họ có khi còn dễ mến hơn một số người “bình thường” khác. Cha tôi thì luôn yêu thương và đứng bên cạnh mẹ.\n" +
                "\n" +
                "Nghĩ mẹ luôn chấp nhận hoàn cảnh với tinh thần lạc quan, tỉnh táo nên hầu như chẳng khi nào tôi thấy buồn hay phẫn uất về điều đó. Tôi không bao giờ quên cái ngày mà suy nghĩ tự mãn đó trong tôi tan như bọt xà phòng. Ấy là vào một dịp gia đình mở tiệc lúc tôi đã là thiếu nữ. Đúng lúc hình ảnh mẹ duyên dáng trong bộ đồ dạ hội, mang đôi giày cao gót đã phai nhạt trong tiềm thức tôi, thì tôi chợt bắt gặp mẹ ngồi ngoài cuộc vui, mỉm cười nhìn tôi và bạn bè khiêu vũ. Tim tôi như thắt lại trước khung cảnh tương phản với sự tật nguyền của mẹ. Thế rồi, hình ảnh mẹ tôi rạng ngời đang khiêu vũ bỗng ùa về trước mắt tôi.\n" +
                "\n" +
                "Tôi tự hỏi không biết mẹ có cảm nhận giống mình không. Một cách vô thức, tôi tiến về phía mẹ, và, dù đôi môi mẹ đang mỉm cười nhưng tôi thấy mắt mẹ ngấn lệ. Tôi bỏ chạy về phòng, úp mặt vào gối khóc nức nở. Từ giây phút đó, tôi cảm nhận sức mạnh tinh thần của mẹ - dám chấp nhận hy sinh những thú vui mình yêu thích.\n" +
                "\n" +
                "Lớn lên tôi làm việc trong môi trường cải tạo phạm nhân, và mẹ rất thích giúp đỡ tôi. Mẹ đề nghị được dạy cách sáng tác văn chương cho các học viên của tôi. Khi không thể đến nhà tù được nữa, mẹ vẫn thường xuyên viết thư cho họ. Một ngày nọ, mẹ nhờ tôi gửi thư cho một tù nhân tên Waymon. Mang máng nghĩ mình sắp biết thêm điều gì đó về mẹ, tôi xin phép mẹ đọc lá thư ấy trước. Mẹ đồng ý. Lá thư viết:\n" +
                "\n" +
                "“Ông Waymon thân mến!\n" +
                "\n" +
                "Tôi đã suy nghĩ rất nhiều về lá thư của ông. Ông nói rằng cuộc sống sau những chấn song sắt thật khắc nghiệt. Tôi hoàn toàn thông cảm với ông. Nhưng khi ông bảo tôi không thể hình dung được cảnh sống bị giam cầm như thế nào thì tôi khẳng định là ông đã lầm!\n" +
                "\n" +
                "Waymon ạ! Trên đời có nhiều kiểu tự do và nhiều dạng ngục tù. Vả lại, đôi khi chính chúng ta tự tạo ra nhà tù cho mình đấy chứ.\n" +
                "\n" +
                "Ở tuổi 31, tôi bỗng mất khả năng đi lại. Tôi đã cảm giác như đất lở dưới chân mình. Tâm trí lấn cấn mãi ý nghĩ rằng, suốt phần đời còn lại mình sẽ bị giam cầm trong cơ thể mình, không còn được tự do đi lại, khiêu vũ hoặc ôm các con vào lòng nữa.\n" +
                "\n" +
                "Vất vả lắm tôi mới chấp nhận tình trạng của mình, cố không đắm chìm trong sự buồn tủi. Biết bao lần tôi tự hỏi liệu cuộc đời này có còn đáng sống nữa không; luôn bị ám ảnh bởi hai chữ “tù đày” và tuyệt vọng vì những thứ quan trọng đối với mình đã mất đi.\n" +
                "\n" +
                "Nhưng rồi một ngày kia tôi chợt nhận ra mình còn được quyền chọn lựa. Nên cười hay khóc khi gặp các con? Sẽ trở thành một người mẹ mẫu mực hay người mẹ chết héo trong tâm tưởng chúng? Nên nguyền rủa hay cầu xin Thượng Đế ban cho sức mạnh dựa vào niềm tin?\n" +
                "\n" +
                "Tôi quyết định chừng nào còn sống, tôi vẫn phải nỗ lực; phải hành động tích cực; và cố mở rộng biên giới tinh thần để bù lại những hạn chế về thể chất.\n" +
                "\n" +
                "Có nhiều dạng tự do, Waymon a! Khi chúng ta mất một tự do này, đơn giản ta phải tìm kiếm tự do khác.\n" +
                "\n" +
                "Ông có thể nhìn trời u ám hoặc chân trời tươi đẹp qua những chấn song, ông có thể là tấm gương sáng cho lớp trẻ hay chịu hòa lẫn vào những kẻ xấu. Về phương diện nào đó, giữa tôi và ông đều cùng chung một cảnh ngộ, ông Waymon ạ!”\n" +
                "\n" +
                "Đọc xong, tôi mới vỡ lẽ, những điều trước kia tôi coi là đương nhiên nay đã trở thành nguồn động viên bí ẩn và vô cùng mạnh mẽ.',2,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Không việc gì phải lo','Cuộc sống không cố ý muốn làm chúng ta sợ hãi mà chỉ muốn chúng ta thấu hiểu nó mà thôi\n" +
                "\n" +
                "- Marie Curie\n" +
                "\n" +
                "Tôi từng sống trong nỗi sợ triền miên. Sợ phải mất đi những gì mình đang có; sợ chẳng bao giờ đạt được những gì mình ao ước.\n" +
                "\n" +
                "Sẽ ra sao nếu trên đầu tôi chẳng còn sợi tóc nào?\n" +
                "\n" +
                "Sẽ ra sao nếu tôi chẳng bao giờ có được một ngôi nhà tươm tất?\n" +
                "\n" +
                "Sẽ ra sao nếu dáng dấp của tôi bỗng hóa ra phục phịch, mất đi vẻ hấp dẫn?\n" +
                "\n" +
                "Sẽ ra sao nếu tôi mất việc?\n" +
                "\n" +
                "Sẽ ra sao nếu tôi bị tật nguyền và không thể cùng chơi bóng với các con?\n" +
                "\n" +
                "Sẽ ra sao nếu tôi già yếu và chẳng thể cảm nhận đầy đủ và không có ích gì cho những người xung quanh?\n" +
                "\n" +
                "Nhưng cuộc sống luôn ưu ái những ai biết lắng nghe, và giờ đây tôi hiểu:\n" +
                "\n" +
                "Nếu trên đầu không còn sợi tóc nào, tôi sẽ cố gắng để trở thành một kẻ hói đầu giỏi nhất. Và tôi sẽ biết ơn\n" +
                "\n" +
                "cái đầu trơ chân tóc của mình vẫn nảy sinh những ý tưởng mới.\n" +
                "\n" +
                "Ngôi nhà không làm cho người ta hạnh phúc. Trái tim đau khổ đâu thể thỏa lòng trong một ngôi nhà rộng lớn. Trong khi trái tim tràn ngập niềm vui sẽ mang hạnh phúc phủ đầy bất kỳ ngôi nhà nào.\n" +
                "\n" +
                "Nếu tôi dành thời gian để hoàn thiện tâm hồn, tình cảm và trí tuệ của mình, thay vì chỉ chăm chăm trau chuốt hình thể bên ngoài, thì tôi sẽ đẹp hơn lên mỗi ngày.\n" +
                "\n" +
                "Nếu không ai nhận tôi làm việc, tôi sẽ làm những việc mà mình thích - trên đời này liệu có gì sánh được với sự tự do thể hiện mình?\n" +
                "\n" +
                "Nếu vì tàn tật mà tôi không thể dạy con cách đá bóng, thì tôi sẽ có nhiều thời gian hơn để hương dẫn nó cách xử trí những đường bóng hiểm hóc của cuộc đời. Điều này có ích cho chúng hơn.\n" +
                "\n" +
                "Còn nếu như tuổi tác lấy đi sức khỏe, khả năng nhạy bén và thể lực của tôi, tôi sẽ trao tặng những người quanh mình sức mạnh của niềm tin, sự sâu sắc của tình yêu, và sự trẻ trung của một tâm hồn đã được định hình bởi bao chông gai cuộc đời.\n" +
                "\n" +
                "Dù số phận tôi có phải hứng chịu những mất mát đau thương, những thất vọng đắng cay ê chề đến đâu chăng nữa, tôi vẫn sẽ đương đầu với từng thử thách bằng tất cả nghị lực và bản lĩnh của mình. Vì cuộc sống đã ban cho tôi nhiều món quà; mà mỗi món quà mất đi, tôi sẽ được đền bù bằng mười món quà khác. Suy nghĩ đó giúp tôi luôn tự tin và yêu đời hơn.',3,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cuộc sống vẫn còn ý nghĩa','Tôi chỉ có một mình, nhưng tôi vẫn là một người; tôi không thể làm tất cả; nhưng tôi vẫn có thể làm điều gĩ đó; và vì không thể làm được tất cả nên tôi sẽ không từ chối làm bất cứ điều gì mà tôi có thể.\n" +
                "\n" +
                "- Edward Everett Hale\n" +
                "\n" +
                "Chăm sóc các bệnh nhân đột quỵ trong bệnh viện là một công việc có thể mang người ta đến hai cực của trạng thái. Bởi các bệnh nhân hoặc thường hết sức mang ơn khi được cứu sống hoặc chỉ muốn chết. Chỉ cần nhìn thoáng qua người bệnh ta sẽ biết tất cả.\n" +
                "\n" +
                "Albert đã dạy tôi rất nhiều về ý chí nỗ lực.\n" +
                "\n" +
                "Một buổi chiều, trong khi đang đi dạo loanh quanh các phòng bệnh tôi gặp ông nằm co tròn như một bào thai. Đó là một người đàn ông già nua, xanh xao, có cái nhìn như người chết, đang vùi nửa đầu dưới tấm chăn, ông ấy không hề nhúc nhích khi tôi tự giới thiệu, và cũng chẳng nói gì khi tôi hối ông đi ăn tối.\n" +
                "\n" +
                "Một người phục vụ tại phòng y tá cho tôi biết một số thông tin về ông. Ông không có người thân và đã cao tuổi. Vợ ông đã qua đời, còn năm người con trai cũng khôn lớn và rời xa ông.\n" +
                "\n" +
                "Cólẽ tôi nên làm gì đó để giúp cho ông. Là một y tá đã ly hôn, tuy hơi thấp người và đẫy đà một chút nhưng xinh xắn và đang tránh né những người đàn ông mà công việc không đòi hỏi phải tiếp xúc, tôi bắt đầu một kế hoạch khuyến khích ông.\n" +
                "\n" +
                "Ngày hôm sau, tôi mặc một chiếc áo đầm trắng, không phải là bộ đồng phục y tá thường ngày. Tôi đến phòng Albert - căn phòng không mở đèn và các màn cửa đều kéo xuống.\n" +
                "\n" +
                "Albert la hét đuổi các nhân viên ra ngoài. Tôi kéo ghế lại ngồi gần giường ông ta, bắt chéo đôi chân quyến rũ của mình, nghiêng đầu và nở một nụ cười hết sức duyên dáng.\n" +
                "\n" +
                "- Hãy để mặc tôi. Tôi muốn chết.\n" +
                "\n" +
                "- Anh làm như thế là có tội đó. Anh không nhận thấy phụ nữ độc thân chúng tôi còn đầy ra cả đấy hay sao?\n" +
                "\n" +
                "Trông ông có vẻ bực mình. Tôi cứ huyên thuyên về việc tại sao tôi thích làm công việc săn sóc người ốm bởi nó khiến tôi phải theo dõi người ta đạt được tối đa tiềm năng của họ và như thế họ có nhiều khả năng làm được nhiều điều kỳ diệu... Ông cũng chẳng hé lấy một lời.\n" +
                "\n" +
                "Hai ngày sau trong buổi họp giao ban, tôi được biết Albert đã hỏi thăm khi nào thì đến ca trực của tôi. Người y tá được giao trông nom ông đã ghép ông là “bạn trai” của tôi và đồn đại khắp bệnh viện. Tôi cũng chẳng tranh cãi về chuyện đó. Bên ngoài phòng bệnh, tôi bảo mọi người đừng quấy rầy “Albert của tôi”.\n" +
                "\n" +
                "Chẳng bao lâu sau ông bắt đầu chịu cử động, ông ngồi ở mép giường để tập giữ thăng bằng, tăng sức chịu đựng trong khi ngồi, ông đồng ý tập vật lý trị liệu nếu tôi quay lại chuyện trò.\n" +
                "\n" +
                "Hai tháng sau, Albert lên khung tập đi. Đến tháng thứ ba, ông đã đi được bằng gậy. Vào những ngày thứ sáu, chúng tôi thường tổ chức liên hoan ngoài trời ăn mừng những bệnh nhân xuất viện. Albert và tôi đã cùng nhảy trong giai điệu du dương, tuy không ra dáng một người đàn ông lịch lãm cho lắm nhưng ông nhảy thật tuyệt. Lần nào ông cũng bịn rịn khi chúng tôi từ biệt nhau.\n" +
                "\n" +
                "Rồi theo mùa lần lượt hoa hồng, hoa cúc và những bông đậu Hà Lan ngọt ngào đua nhau nở rộ. Albert xuất viện và trở lại cuộc sống làm vườn ông yêu thích.\n" +
                "\n" +
                "Một buổi chiều nọ, có một phụ nữ xức nước hoa oải hương đáng yêu đến bệnh viện và yêu cầu được gặp “Người phụ nữ bị coi là mất nết”.\n" +
                "\n" +
                "Tôi được gọi ra gặp người phụ nữ ấy khi đang dở tay lau giường.\n" +
                "\n" +
                "- Cô là người phụ nữ đã nhắc cho Albert của tôi nhớ rằng anh ấy là một người đàn ông!\n" +
                "\n" +
                "Cô ta nghiêng đầu cười tươi và trao cho tôi một tấm thiệp cưới.',4,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Ý nghĩa của nụ cười','Không có công việc nào là nhỏ nhoi hay thấp kém, mà chỉ có người không tĩm thấy Ý nghĩa trong công việc của mình mà thôi.\n" +
                "\n" +
                "- Khuyết danh\n" +
                "\n" +
                "Có một ông chủ kinh doanh nọ sang Nhật Bản công tác. Tuy là người thành đạt nhưng ông rất khiêm tốn và luôn chia sẻ thành công với nhân viên của mình. Sau khi hoàn tất công việc, ông đến một siêu thị để mua các món quà cho nhân viên của mình trước khi về nước.\n" +
                "\n" +
                "Khi ông bước vào siêu thị, một người phụ nữ dáng vẻ nhỏ nhắn đón chào ông bằng một nụ cười nồng ấm khiến ông rất cảm động, hài lòng và không thể quên thái độ thân thiện đó. Trong khi mua sắm, thỉnh thoảng ông liếc nhìn người phụ nữ kia, cô đều dành nụ cười tươi như thế cho mọi khách hàng.\n" +
                "\n" +
                "Nhà kinh doanh nọ bắt đầu tự hỏi tại sao cô ta cứ cười mãi như một cái máy thế. Đứng cười mãi suốt ngày như thế thì thật là chán ngấy! Ông bèn bước đến gần cô hỏi:\n" +
                "\n" +
                "- Chào cô, không phải là cô đang cố làm công việc này đấy chứ? Cô đã làm như thế này bao lâu rồi?\n" +
                "\n" +
                "Người phụ nữ mỉm cười, đáp:\n" +
                "\n" +
                "- Thưa ông, tôi đã làm việc này 10 năm nay rồi và tôi rất yêu công việc của mình.\n" +
                "\n" +
                "Nhà kinh doanh hết sức ngạc nhiên, hỏi tiếp:\n" +
                "\n" +
                "- Tại sao cô lại theo đuối công việc này lâu như thế? Lý do gì khiến cô yêu thích nó?\n" +
                "\n" +
                "Người phụ nữ lại nở nụ cười:\n" +
                "\n" +
                "- Vì nhờ công việc này mà tôi được cống hiến cho đất nước mình.\n" +
                "\n" +
                "Nhà kinh doanh hơi mỉa mai:\n" +
                "\n" +
                "- Cô cống hiến cho đất nước bằng cách cười sao?\n" +
                "\n" +
                "- Vâng, thưa ông. - Người phụ nữ đáp. - Tôi cười với tất cả khách hàng đến đây để họ thấy hài lòng và thoải mái. Khi đó, họ sẽ mua sắm nhiều hơn, ông chủ của tôi sẽ vui hơn và tôi sẽ được trả lương nhiều hơn. Do đó, tôi có thể chăm sóc gia đình mình và mang hạnh phúc đến cho họ. Hơn nữa, khi có đông khách hàng, nhu cầu hàng hóa sẽ tăng lên, sẽ cần có thêm nhiều nhà máy và nhiều công ăn việc làm được tạo ra. Không chỉ thế, vì phần đông khách hàng của chúng tôi là người ngoại quốc nên sẽ có thêm nhiều cơ hội giao thương với nước ngoài, như thế nước tôi sẽ ngày càng thịnh vượng hơn. Những người như ông sẽ đến nước tôi thường xuyên hơn vì ông hài lòng với chúng tôi và có thể ông sẽ kể về chúng tôi với bạn bè và gia đình ông. Thế nên, đất nước chúng tôi sẽ có thêm nhiều du khách, nhiều ngoại tệ, nhiều việc làm và nhiều người sẽ hạnh phúc. Như vậy là tôi đã cống hiến cho đất nước mình rồi.\n" +
                "\n" +
                "Thái độ và suy nghĩ của người phụ nữ về công việc đã khiến nhà kinh doanh kia hết sức ngạc nhiên và khâm phục, ông chào cô rồi ra về. Từ sau đó, ông đã cố gắng truyền đạt thái độ ấy cho các nhân viên của mình. Đến hôm nay, công ty của ông đã trở thành một trong những công ty tiếng tăm nhất trên thế giới.\n" +
                "\n" +
                "Đón nhận những kinh nghiệm tiêu cực và nhìn chúng một cách tích cực. Bạn sẽ học được rất nhiều từ những chuyện đã qua. Đừng để người khác mãi phán xét bạn chỉ dựa vào một lỗi lấm nào đó. Hãy để quá khứ lại phía sau, nhưng đừng lãng quên nó.\n" +
                "\n" +
                "- Khuyết danh',5,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Không bao giờ quá muộn','Với tôi, sự trưởng thành bắt đầu ngay khi tôi có thể thú nhận lỗi lầm và tha thứ cho chính bản thân mình.\n" +
                "\n" +
                "- Kimberly Kirberger\n" +
                "\n" +
                "Cách đây vài năm, khi tham dự khóa học về giao tiếp, giảng viên đã truyền đạt cho chúng tôi một bài học về cách xử trí hết sức lạ lùng. Chúng tôi được yêu cầu suy nghĩ và liệt kê ra tất cả những lỗi lầm hoặc những việc chưa chu toàn trong quá khứ mà đến nay vẫn còn khiến mình hổ thẹn, day dứt.\n" +
                "\n" +
                "Qua tuần tiếp theo, cô giáo khuyến khích học viên lên thuyết trình trước lớp về đề tài này. Vì đây là những mảng tối rất riêng tư và tế nhị trong đời mỗi cá nhân, nên những người xung phong lên trình bày đều là những “bậc” dũng khí đầy mình. Hễ cứ ai đó đứng lên là danh sách những điều ân hận của tôi lại dài ra thêm, đến hơn 101 việc. Cô giáo đề nghị chúng tôi tự tìm giải pháp để sửa chữa những hành động đó, chuộc lại lỗi lầm xưa. Thật tình tôi rất phân vân, tự hỏi liệu cách này có giúp cải thiện các mối giao tiếp của mình không hay là... trong đầu tôi hình dung ra cảnh bị mọi người lạnh nhạt sau khi làm theo lời cô.\n" +
                "\n" +
                "Sang tuần sau nữa, người ngồi kế bên tôi giơ tay xin kể lại câu chuyện như sau:\n" +
                "\n" +
                "“Đó là sự kiện xảy ra khi tôi còn học trung học tại một thị trấn nhỏ thuộc bang Iowa. Ngày ấy, chúng tôi chúa ghét Brown, viên cảnh sát trưởng nơi chúng tôi sinh sống. Một đêm, tôi cùng hai đứa bạn quyết định chơi khăm ông ta. Sau khi uống vài ly bia trong quán, chúng tôi xách thùng sơn ra bồn chứa nước công cộng ngay giữa phố, rồi viết lên đó hàng chữ lớn đỏ rực: “Cảnh sát trưởng Brown là đồ khốn!”. Ngày hôm sau, hàng chữ chói chẳng ấy nổi bật dưới ánh mặt trời, đập ngay vào mắt người dân ở khu phố vừa mới thức dậy. Chưa đầy hai tiếng đồng hồ, ông Brown đã triệu được cả ba chúng tôi lên đồn cảnh sát. Hai bạn tôi thú nhận, nhưng tôi thì chối phăng. Chẳng ai phát hiện ra điều đó cả.\n" +
                "\n" +
                "Gần hai mươi năm sau, nhân tham dự lớp học này, cái tên “Cảnh sát trưởng Brown” chợt hiện trong danh sách lỗi lầm của tôi. Tôi không biết giờ ông ấy có còn sống hay không. Cuối tuần rồi, tôi bèn gọi điện cho khu phố quê hương xưa, hỏi thăm thông tin và được biết về một người tên là Roger Brown. Tôi liền liên lạc với người này. Sau vài hồi chuông, người ở đầu dây bên kia nhấc máy:\n" +
                "\n" +
                "- Xin chào! - Tôi mở lời - Thưa, chú là cảnh sát trưởng Brown phải không ạ?\n" +
                "\n" +
                "- Phải - Tôi nghe sau vài giây im lặng.\n" +
                "\n" +
                "- À, cháu là Jimmy Calkin đây. Cháu muốn chú biết rằng chính cháu đã viết bậy lên bồn nước dạo ấy.\n" +
                "\n" +
                "Lại im lặng, rồi bỗng ông nói như hét:\n" +
                "\n" +
                "- Tôi biết mà!\n" +
                "\n" +
                "Và rồi chúng tôi cùng nói chuyện vui vẻ và chân tình. Trước khi gác máy, ông Brown bảo tôi:\n" +
                "\n" +
                "- Jimmy à, hồi ấy tôi cảm thấy thương thay cho cậu. Bởi vì hai bạn cậu đã trút bỏ được gánh nặng do sự bồng bột của mình còn cậu vẫn phải mang nó theo suốt những năm tháng vừa qua. Tôi cảm ơn cậu đã gọi điện cho tôi... vì lợi ích của chính bản thân cậu.”\n" +
                "\n" +
                "Câu chuyện của Jimmy giúp tôi can đảm “gột sạch” từng tội trong 101 lỗi lầm quá khứ của mình. Tuy phải mất gần hai năm, nhưng bù lại, điều đó lại là nguồn cảm hứng thôi thúc tôi chọn cho mình một sự nghiệp chuyên hòa giải những xung đột. Cho dù hoàn cảnh hay nguyên nhân bất hòa mà khách hàng của tôi nhờ gỡ rối có khó khăn đến đâu đi nữa, lúc nào tôi cũng luôn tâm niệm một điều rằng: chẳng bao giờ quá muộn để sửa chữa những sai lầm để bắt đầu một cuộc sống mới cả.',6,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Lỗi lầm','Phương thuốc chữa khỏi mọi bệnh tật, lỗi lầm, nỗi bận tâm, ưu phiền và tội lỗi của con người, tất cả đều nằm ở một từ yêu”. Đó là sức mạnh tuyệt vời để sản sinh và tái tạo sự sống.\n" +
                "\n" +
                "- Lydia Maria Child\n" +
                "\n" +
                "Tôi gặp gia đình của Jane White khi tôi bước vào năm đầu tiên của đời sinh viên. Tôi và cô ấy học chung một lớp. Lần đầu tiên tôi đến nhà Jane, tôi cảm thấy không khí ấm áp như ở nhà mình, dù gia đình họ hoàn toàn chẳng có chút gì giống gia đình tôi.\n" +
                "\n" +
                "Trong gia đình tôi, khi có bất cứ chuyện gì không hay xảy ra, điều đầu tiên và quan trọng nhất cần làm là tìm ra người nào phạm lỗi.\n" +
                "\n" +
                "- Đứa nào bày ra như thế này? - Mẹ tôi sẽ hỏi ngay như vậy khi thấy nhà bếp bề bộn ngổn ngang.\n" +
                "\n" +
                "- Cái này chắc là tại Catherine hết đây! - Cha tôi sẽ khẳng định như vậy khi chiếc xe hơi bị hư hay máy rửa chén ngừng chạy.\n" +
                "\n" +
                "Ngay từ hồi còn nhỏ, mấy anh chị em tôi đã quen với việc mách tội của nhau. Chúng tôi đã dành hẳn một chỗ cho việc đổ lỗi: tại bàn ăn.\n" +
                "\n" +
                "Nhưng gia đình họ White này thì không như vậy. Họ chẳng quan tâm đến việc ai đã phạm sai lầm gì. Họ lướt qua những lỗi lầm của nhau và tiếp tục vui vẻ sống. Vẻ đẹp đáng quý ấy đã thấm sâu trong tôi vào cái mùa hè mà Jane chia tay cuộc sống.\n" +
                "\n" +
                "Gia đình White có sáu người con: ba trai và ba gái. Một người con trai đã chết từ bé, có lẽ chính vì thế mà năm anh em còn lại rất gần gũi nhau.\n" +
                "\n" +
                "Đó là một ngày tháng bảy, mấy chị em gái của Jane và tôi quyết định lái xe lên New York chơi. Từ Florida, nơi họ ở, đếnNew York khá xa. Lúc ấy, Amy, con gái út trong nhà, mới tròn 16. Cô bé mới lấy được bằng lái nên rất hãnh diện và hào hứng khi được lái xe trên đường đi. Amy vui vẻ khoe tấm bằng của mình với mọi người nó gặp.\n" +
                "\n" +
                "Ban đầu, chị Sarah và Jane thay nhau xem chừng Amy lái, nhưng đến những quãng đường vắng vẻ, họ đã để Amy tự lái một mình. Chúng tôi dừng lại ăn trưa. Sau đó, Amy tiếp tục cầm lái. Đến một giao lộ khi đèn đỏ bật lên, chẳng biết do bối rối hay lơ đễnh không trông thấy, Amy vẫn tiếp tục chạy qua. Một chiếc xe tải đã đâm sầm vào xe chúng tôi.\n" +
                "\n" +
                "Jane chết ngay tức khắc.\n" +
                "\n" +
                "Tôi chỉ bị xây xát nhẹ. Và điều khó khăn nhất mà tôi phải làm lúc ấy là gọi về nhà Jane để báo tin dữ. Mất một người bạn tôi đã thấy đau đớn lắm rồi, với bố mẹ Jane, chẳng biết họ sẽ khó khăn đến dường nào.\n" +
                "\n" +
                "Khi hai ông bà đến bệnh viện, thấy ba chúng tôi nằm chung phòng họ đã ôm chúng tôi mà khóc, vừa đau đớn vừa mừng. Mừng vì Sarah và Amy còn sống. Sarah bị thương ở đầu còn Amy thì bị gãy chân. Họ lau nước mắt cho hai cô con gái và còn chọc Amy vài câu khi giúp cô bé tập mang cây nạng.\n" +
                "\n" +
                "Họ chỉ nói đi nói lại với hai cô con gái và đặc biệt với Amy: “Các con còn sống là ba mẹ mừng rồi!”.\n" +
                "\n" +
                "Tôi thật ngạc nhiên. Chẳng một lời trách móc hay buộc tội nào!\n" +
                "\n" +
                "Sau này, có một lần tôi hỏi mẹ Jane tại sao họ không bao giờ đả động gì đến việc Amy lái xe vượt đèn đỏ, bà ngậm ngùi trả lời rằng:\n" +
                "\n" +
                "- Jane đã đi rồi, bác nhớ nó vô cùng. Có nói gì cũng chẳng mang nó về lại được. Còn Amy có cả một quãng đời phía trước. Làm sao nó sống vui vẻ và hạnh phúc được khi nó cứ mang cảm giác tội lỗi là chính nó đã gây ra cái chết cho chị mình?\n" +
                "\n" +
                "Bà nói đúng. Giờ đây, Amy đã tốt nghiệp đại học và đã lập gia đình. Amy làm giáo viên cho một trường khuyết tật và hiện đang là mẹ của hai cô con gái nhỏ, đứa con đầu lòng cũng mang tên Jane.\n" +
                "\n" +
                "Tôi đã học được bài học từ gia đình Jane: việc đổ lỗi cho ai vì bất cứ chuyện gì là không quan trọng. Đôi khi, nó chẳng có tác dụng gì.',7,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mãi mãi tuổi 17','Những giọt nước mắt đắng cay, xót xa nhất nhỏ xuống những ngôi mộ người thân chính là những lời chưa kịp nói và những điều chưa kịp làm.\n" +
                "\n" +
                "- Harriet Beecher Stowe\n" +
                "\n" +
                "Nỗi đau đớn cực độ giày vò tâm trí tôi. Giờ tôi chỉ còn là một con số thống kê vô hồn. Khi mới đến đây, tôi cảm thấy cô độc lạ thường. Tôi ngập chìm trong đau khổ và mong tìm được ai đó cảm thông, chia sẻ.\n" +
                "\n" +
                "Nhưng tôi đã không tìm được một sự cảm thông nào. Chung quanh tôi là hàng ngàn thân xác khác cũng bị bầm giập như tôi. Tôi được gắn cho một con số và bị phần vào nhóm những người “Chết vì tai nạn giao thông”.\n" +
                "\n" +
                "Cái ngày tôi từ giã cõi đời này là một ngày đi học bình thường như bao ngày khác. Chao ôi, ước gì lúc ấy tôi đã chịu đi xe buýt! Nhưng tôi đã quá ác cảm với xe buýt. Tôi nhớ là mình đã làm mình làm mẩy với mẹ để lấy xe hơi đi cho bằng được.\n" +
                "\n" +
                "- Cho con lái đi mà mẹ. - Tôi nài nỉ. - Bạn con đứa nào cũng đi xe hơi cả mà có sao đâu.\n" +
                "\n" +
                "Khi chuông reng lúc 2 giờ 30 phút chiều, tôi quẳng vội sách vở vào ngăn tủ của mình và tự nhủ: “Mình được tự do đến sáng mai!”.\n" +
                "\n" +
                "Tôi chạy nhanh đến chỗ đậu xe, hứng chí với ý nghĩ sẽ được ngồi sau tay lái chiếc xe hơi và muốn làm gì với nó thì làm.\n" +
                "\n" +
                "Tai nạn xảy ra như thế nào giờ đây không còn quan trọng nữa. Tôi đã làm điều dại dột - phóng xe rất nhanh và trổ tài lạng lách. Nhưng lúc ấy tôi lại đang cho rằng đó là sự tận hưởng tự do của mình và lấy đó làm điều khoái trá. Điều cuối cùng tôi còn nhớ là tôi mới vừa chạy ngang qua một bà cụ có vẻ như đang đi rất chậm. Rồi tôi nghe một tiếng va chạm lớn, người tôi bị chao đảo khủng khiếp. Kiếng và sắt thép văng ra khắp nơi. Toàn thân tôi như bị lộn nhào cả lên. Tôi nghe một tiếng thét kinh hoàng từ chính miệng mình và rồi không biết gì nữa cả.\n" +
                "\n" +
                "Bổng nhiên tôi tỉnh dậy, chung quanh hoàn toàn im lặng. Một nhân viên cảnh sát đang đứng phía trên tôi bên cạnh một bác sĩ. Toàn thân tôi đầy thương tích. Cả người tôi đẫm máu. Những mảnh kiếng vụn nhọn hoắt găm khắp thân tôi. Điều lạ lùng là tôi không cảm thấy đau đớn gì cả. Này, đừng kéo tấm vải phủ kín mặt tôi như vậy chứ! Tôi không thể chết. Tôi chỉ mới 17 tuổi. Tối nay tôi còn có hẹn với bạn gái tôi nữa. Bao nhiêu điều thú vị trong cuộc sống còn đang chờ đợi tôi phía trước. Tôi vẫn chưa thụ hưởng hết mà. Không! Không! Tôi không thể chết được!\n" +
                "\n" +
                "Rồi người ta đặt tôi vào trong một cái hộc. Gia đình đến nhận dạng tôi. Tại sao người thân phải chứng kiến tôi trong tình trạng như thế này? Tại sao tôi phải nhìn vào mắt của mẹ khi mẹ đang phải đương đầu với nỗi đau khủng khiếp nhất trong cuộc đời mình? Cha trông già sọm hẳn đi. Cha nói với người đàn ông trực ở đấy:\n" +
                "\n" +
                "- Vâng! Đó chính là con trai chúng tôi.\n" +
                "\n" +
                "Đám tang cũng thật kỳ lạ. Tôi thấy tất cả họ hàng và bạn bè đi về phía quan tài mình nằm. Họ nhìn tôi bằng đôi mắt buồn bã nhất mà tôi từng thấy. Một vài đứa bạn tôi khóc sụt sùi. Vài cô gái sờ vào tay tôi và nức nở quay đi.\n" +
                "\n" +
                "Ai đó làm ơn đánh thức tôi dậy! Tôi xin các người. Hãy đem tôi ra khỏi chỗ này. Tôi không thể chịu đựng nỗi khi nhìn thấy cha và mẹ đau khổ như thế. Ông bà tôi suy sụp, bước đi không vững. Anh chị em tôi thờ thẫn như những bóng ma và cử động như người máy. Mọi người bằng hoàng. Không ai tin được chuyện này. Chính tôi cũng không tin.\n" +
                "\n" +
                "Làm ơn đừng chôn tôi! Tôi không chết!\n" +
                "\n" +
                "Tôi có nhiều chuyện phải làm! Tôi muốn cười đùa và chạy nhảy trở lại.\n" +
                "\n" +
                "Tôi muốn ca hát và nhảy múa. Làm ơn đừng chôn tôi dưới lớp đất kia!\n" +
                "\n" +
                "“Con hứa nếu Thượng Đế cho con thêm một cơ hội nữa, con sẽ là người lái xe cẩn thận nhất trên thế giới này. “\n" +
                "\n" +
                "Tất cả những điều tôi muốn là hãy cho tôi thêm một cơ hội nữa.\n" +
                "\n" +
                "“Làm ơn đi Thượng Đế, con chỉ mới 17 tuổi thôi. “',8,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Nguồn động viên','Một số những câu chuyện về sự thành công vĩ đại nhất trong lịch sử đều xuất phát từ một lời động viên hay sự tin tưởng của một người yêu hay một người bạn đáng tin cậy. Nếu không nhờ một người vợ có niềm tin mạnh mẽ như Sophia, chúng tôi hẳn đã không liệt kê giữa những tên tuổi vĩ đại của nền văn học Mỹ cái tên Nathaniel Hawthorne.\n" +
                "\n" +
                "Một ngày nọ khi Nathaniel đau khổ đi về nhà và bảo với vợ rằng ông vừa bị mất việc, bà đã khiến ông ngạc nhiên bằng một câu nói phấn khởi.\n" +
                "\n" +
                "- Thế thì giờ anh đã có thời gian để viết sách rồi!\n" +
                "\n" +
                "- Ừ - ông đáp trong sự lo lắng, - nhưng chúng ta sẽ sống bằng cái gì khi anh đang viết?\n" +
                "\n" +
                "Trước sự ngạc nhiên của chồng, Sophia mở một ngăn kéo và rút ra một số tiền đáng kể.\n" +
                "\n" +
                "- Em lấy số tiền đó ở đâu vậy? - ông la lên.\n" +
                "\n" +
                "- Em vẫn luôn biết rằng anh là một thiên tài. - Bà bảo - Em đã biết rằng một ngày nào đó anh sẽ viết nên một kiệt tác. Cho nên mỗi tuần em đã giữ lại một ít trong số tiền chợ anh đưa cho em. Chỗ này đủ cho chúng ta sống qua một năm.\n" +
                "\n" +
                "Với sự tin tưởng và kỳ vọng của vợ, Nathaniel đã cho ra đời một trong những tiểu thuyết vĩ đại nhất của văn học Mỹ: “Chữ A màu đỏ”.',9,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Giai điệu tuyệt vời','Hết thảy chúng ta đều là những thiên thần một cánh; và chúng ta chỉ bay được khi ômchặt lấy nhau.\n" +
                "\n" +
                "- Luciano De Cresehenzo\n" +
                "\n" +
                "Mùa xuân năm 1983, bà Margaret Patrick, một phụ nữ da đen, tới trung tâm người già cô đơn ở Southeast để theo tập chương trình vật lý trị liệu. Khi được giấm đốc dẫn đi thăm cơ sở vật chất, bà Margaret bỗng sựng lại, nhìn trân trân vào cây đàn piano trong góc phòng. Bắt gặp ấnh mắt ấy, bà giám đốc hỏi:\n" +
                "\n" +
                "- Có điều gì không ổn với bà chăng?\n" +
                "\n" +
                "- Không, - bà Margaret đáp khẽ, - chỉ vì nó gọi lên những ký ức xa xưa. Trước khi bị đột quỵ âm nhạc đã là lẽ sống của đời tôi.\n" +
                "\n" +
                "Rồi người cựu nghệ sĩ dương cầm ấy tư lự kể về những khoảnh khắc thăng hoa trong sự nghiệp của mình. Nhìn bàn tay bà Margaret buông thõng, giám đốc đột nhiên bảo bà hãy ngồi đợi chút xíu. Lát sau, bà quay lại cùng với một phụ nữ dáng người thấp bé, tay chống gậy, tóc bạc trắng, đeo kính dày cộm. Đó là bà Ruth Eisenberg - cũng từng chơi đàn piano và từng đoạn tuyệt âm nhạc sau cơn đột quy. Hơn nữa, cũng giống như bà Margaret, bà cũng là bà ngoại, bà góa và cũng từng bị mất con. Điều khác biệt giữa họ là mỗi người đều còn lại một bàn tay khỏe mạnh: bà Ruth tay phải và bà Margaret tay trái.\n" +
                "\n" +
                "- Tôi có cảm giác là hai bà sẽ làm nên điều kỳ diệu.\n" +
                "\n" +
                "- Bà giám đốc giải thích.\n" +
                "\n" +
                "- Bà có biết bản Van-sơ của Chopin không? - Bà Ruth hỏi. Bà Margaret gật đầu.\n" +
                "\n" +
                "Thế rồi cả hai sát cánh trên chiếc ghế dài. Một bàn tay da đen với những ngón dài gầy guộc, và một bàn tay da trắng, ngắn ngủn, tròn trịa lướt thoăn thoắt trên phím đàn. Họ đắm chìm trong thế giới của riêng mình, quên bẵng đi sự hiện diện của những người xung quanh.\n" +
                "\n" +
                "Kể từ đó, họ như hình với bóng mang đến tiếng đàn du dương tới hàng triệu khán thính giả. Trên màn ảnh nhỏ, tại nhà thờ, trường học, trung tâm phục hồi chức năng, viện dưỡng lão. Công chúng luôn ngẩn ngơ trước hình ảnh bàn tay vô dụng của bà Margaret quàng sau lưng bà Ruth; và bàn tay yếu đuối của bà Ruth lặng lẽ đặt lên đùi bà Margaret. Thường thì, bàn tay khỏe mạnh của bà Ruth đi nốt còn bàn tay lành lặn của bà Margaret thì đánh đệm theo. Dạo đầu là Chopin, Bach rồi đến Beethoven - nhịp nhàng hơn cả trong mơ. Bà Margaret sung sướng bảo:\n" +
                "\n" +
                "- Âm nhạc của tôi bị cướp đi nhưng bù lại tôi có Ruth.\n" +
                "\n" +
                "Bà Ruth im lặng, khóe mắt ánh lên niềm hạnh phúc.\n" +
                "\n" +
                "Đó là câu chuyện về hai người phụ nữ - bây giờ họ tự gọi mình là Evory và Ivory (gỗ mun và ngà voi - hai vật liệu làm nên chiếc đàn piano).',10,6)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Vị ngọt tình yêu','Yêu có nghĩa là không bao giờ nói hối tiếc.\n" +
                "\n" +
                "- Erich Segal\n" +
                "\n" +
                "Anh gặp chị tại một buổi tiệc. Hôm ấy trông chị thật lộng lẫy. Bao nhiêu chàng trai lịch lãm đến bắt chuyện với chị; còn anh, rất đỗi bình thường và không ai thèm chú ý đến. Khi bữa tiệc gần tàn, anh bước đến mời chị đi uống cà phê. Chị rất ngạc nhiên, nhưng vì phép lịch sự, chị cũng nhận lời.\n" +
                "\n" +
                "Nơi họ ngồi là một quán cà phê xinh xắn. Bên cạnh chị, anh quá bối rối đến nỗi chẳng nói được lời nào. Chị thấy khó chịu và có ý định ra về. Bất chợt, chị nghe anh cất tiếng nói với người bồi bàn:\n" +
                "\n" +
                "- Anh mang cho tôi một chút muối, được không? Tôi muốn pha vào cà phê.\n" +
                "\n" +
                "Mọi người trong quán đưa mắt nhìn về phía anh. Mặt anh đỏ bừng, nhưng anh vẫn bình thản bỏ muối vào tách cà phê của mình và cầm lên uống.\n" +
                "\n" +
                "- Tại sao anh lại có sở thích này? - Chị tò mò hỏi.\n" +
                "\n" +
                "- Hồi còn bé, gia đình tôi sống ở gần biển và tôi rất thích ra biển chơi đùa - Anh ngập ngừng đáp - Tôi biết cảm nhận vị mặn chát của biển, nó giống y như vị của cà phê pha muối này đây. Và mỗi khi dùng cà phê muối, tôi như được nhắc nhở đến tuổi thơ, đến quê nhà của mình. Tôi nhớ quê tôi lắm! Tôi nhớ song thân mình, họ vẫn còn đang sống ở đó - Nói đến đấy, mắt anh ươn ướt.\n" +
                "\n" +
                "Trong lòng chị chợt dâng lên một niềm xúc cảm sâu sắc. Đó là những tình cảm chân thành, xuất phát từ tận đáy lòng anh. Một người đàn ông có thể kể về nỗi nhớ nhà của mình chắc hẳn là người rất yêu mái ấm, biết quan tâm và có trách nhiệm với gia đình. Và rồi chị cũng bắt đầu kể về quê nhà xa xôi của mình, về tuổi thơ và gia đình mình. Cuộc nói chuyện thật sự thú vị và đó cũng là điểm khởi đầu tốt đẹp cho câu chuyện của hai người.\n" +
                "\n" +
                "Họ tiếp tục hò hẹn. Càng lúc chị càng nhận ra anh giống như mẫu người mà chị hằng mơ ước: bao dung, tốt bụng, nồng ấm và cẩn trọng. Một chàng trai đáng yêu như thế mà suýt nữa chị đã quay lưng để lỡ mất! Tất cả là nhờ ly cà phê muối của anh!\n" +
                "\n" +
                "Rồi chuyện tình của họ cũng diễn ra như bao chuyện tình đẹp khác: nàng công chúa kết hôn cùng chàng hoàng tử và họ sống hạnh phúc bên nhau. Và cứ mỗi lần pha cà phê cho anh, chị không quên bỏ vào một ít muối vì chị biết đó là sở thích của anh.\n" +
                "\n" +
                "Bốn mươi năm sau, anh qua đời và để lại cho chị một lá thư:\n" +
                "\n" +
                "“Em yêu!\n" +
                "\n" +
                "Mong em hãy tha thứ cho anh vì anh đã nói dối em.\n" +
                "\n" +
                "Và đó cũng là lời nói dối duy nhất trong suốt cuộc đời anh - cà phê muối. Em còn nhớ lần đầu tiên chúng ta gặp nhau không? Lúc đó anh đã quá hồi hộp. Thật ra anh muốn gọi một ít đường, nhưng lại gọi thành muối. Thật khó để chữa lại nên anh đành lơ đi và bịa ra câu chuyện về cà phê muối. Anh đã chẳng hề nghĩ rằng chính điều đó đã đưa chúng ta đến với nhau! Đã bao lần, anh muốn thú thật với em về điều ấy, nhưng anh sợ... Lúc này đây, biết mình sắp xa nhau mãi mãi, anh không còn thấy sợ nữa khi thú thật với em điều này: anh không hề thích cà phê muối. Vị của nó mới khủng khiếp làm sao! Nhưng anh đã uống nó cho đến cuối đời kể từ khi anh biết em. Anh không cảm thấy ân hận về những gì anh đã làm cho em. Được sống bên em là niềm hạnh phúc lớn lao nhất trong cuộc đời anh. Nếu được sống một lần nữa, anh vẫn sẽ muốn có em bên mình, cho dù anh có phải uống cà phê muối thêm suốt một cuộc đời nữa. “\n" +
                "\n" +
                "Nước mắt chị ướt đẫm cả trang thư.\n" +
                "\n" +
                "Một ngày nọ, có người hỏi chị:\n" +
                "\n" +
                "- Vị của cà phê muối như thế nào nhỉ?\n" +
                "\n" +
                "- Ngọt lắm - Chị đáp.',11,6)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chiếc bình vỡ','Hạnh phúc đồng hành nơi tình bạn.\n" +
                "\n" +
                "- Pam Brown\n" +
                "\n" +
                "Nổi bật trong số những đồ trang trí và những món nữ trang trưng bày trong phòng của một cô bé 15 tuổi là một chiếc bình bằng gốm màu xanh da trời, có vẽ hình những bông hoa màu sắc sặc sỡ. Đó không phải là một chiếc bình đẹp và nguyên vẹn. Nó đã bị rạn nứt ở nhiều nơi. Dù chủ nhân của chiếc bình đã lắp ghép cẩn thận những mảnh vỡ lại, nhưng nhìn từ xa người ta vẫn có thể thấy những vết nứt chi chít của nó. Nếu chiếc bình ấy có thể cất được thành lời thì nó sẽ kể cho bạn nghe về câu chuyện của hai cô gái và tình bạn tuyệt vời giữa họ.\n" +
                "\n" +
                "Amy và June quen nhau trên một chuyến bay khi hai cô bé cùng theo cha từ Bangkok trở về nhà - hai ông bố vốn là đối tác làm ăn của nhau và họ đến Bangkok để tham dự một cuộc họp. June ngồi ở phía sau Amy. Khi bay được nửa quãng đường, Amy ngập ngừng quay lại và đưa cho June một bình hoa màu xanh da trời bằng gốm. Cử chỉ ấy tuy không trang trọng lắm nhưng với hai cô bé điều đó đã được xem như một lời giới thiệu và một vật ký niệm đánh dấu cho tình bạn của họ. June nhận lấy món quà rồi cả hai đều nhìn nhau cười bẽn lẽn. Thế là ngày hôm ấy, tình bạn giản dị giữa hai bé gái cùng bốn tuổi, Amy và June, đã được giao kết.\n" +
                "\n" +
                "Nhiều năm trôi qua, Amy và June cùng nhau lớn lên. Họ chơi chung, học chung và lẽ đương nhiên, họ trở thành những người bạn tâm giao, tin cậy nhất của nhau. Bờ vai của Amy là nơi để June gục đầu vào khóc nức nở, kể lể về nỗi đau buồn khi con chó nhỏ của cô bé bị chết trong một tai nạn xe hơi. Lúc Amy bị mọi người chế giễu khi cô trượt té trong một buổi thi năng khiếu thể dục dụng cụ, June đã có mặt ngay bên cạnh Amy để chia sẻ và bênh vực bạn mình. Khi June bỏ nhà ra đi vào năm lên 10 tuổi sau một cuộc cãi vã với mẹ mình thì chính Amy đã khuyên June quay về nhà. Và June đã là người an ủi Amy khi người chú thân yêu của cô bé qua đời. June đã trở thành một phần của Amy và ngược lại, Amy cũng chiếm một vị trí quan trọng không thể thay thế trong cuộc sống của June.\n" +
                "\n" +
                "Thế nhưng cuộc đời vốn dĩ chẳng bao giờ êm ái, phang lặng như một thảm hoa hồng. Người ta thay đổi khi đến tuổi trưởng thành - có thể tốt hơn hoặc cũng có thể xấu đi. Đôi khi, những thay đổi này khó lòng được chấp nhận. Và ngay cả những tình bạn đặc biệt nhất cũng có thể đổ vỡ. Năm 14 tuổi, Amy bắt đầu có bạn trai, ở lứa tuổi này, đối với Amy, bạn trai đúng là một món quà trời cho. Amy dành hết thời gian hẹn hò với người bạn trai và càng ngày càng ít gặp June. Dù thấy lòng bị tổn thương, June vẫn luôn cố gắng thông cảm với bạn mình. Cô vẫn có mặt bên Amy sau mỗi lần Amy cãi vã với bạn trai và cần đến cô để giải tỏa nỗi buồn. Còn khi June cần đến Amy thì cô lại đang mê mải ở tận đâu đâu với anh bạn của mình. Và cứ thế, Amy vẫn vô tâm và tiếp tục trút gánh nặng ưu phiền lên June. Đến một ngày, quá buồn và thất vọng về thái độ thờ ơ của bạn mình, June đã gọi Amy sang nhà mình để nói chuyện. Trong khi June cố gắng bày tỏ những khó khăn và ưu tư của mình Amy đã không thèm nghe mà còn gạt phắt lời cô.\n" +
                "\n" +
                "- Chuyện ấy nói sau đi.\n" +
                "\n" +
                "Sau đó Amy hỏi ý kiến June về việc cô nên mua quà gì cho bạn trai nhân dịp nửa năm ngày họ quen nhau. Thái độ đó của Amy như giọt nước cuối cùng làm tràn ly. June không thể chịu đựng thêm được nữa. Bao nhiêu giận dữ, đau khổ, oán hờn và thất vọng chất chứa trong cô bao ngày chợt dâng trào, cô òa khóc và lớn tiếng với Amy.\n" +
                "\n" +
                "- Cậu coi tớ là gì chứ, Amy? Là bạn cậu hay chỉ là một con chó bé nhỏ của cậu? - June nói trong nước mắt. Cô hy vọng là Amy sẽ hiểu ra và xin lỗi mình.\n" +
                "\n" +
                "Nhưng không. Amy tìm cách chống chế và hét lại June. Tình bạn gắn bó trong 10 năm của họ đang tan dần trước mắt hai cô gái. Chẳng ai trong họ muốn cứu vãn tình hình.\n" +
                "\n" +
                "- Đúng đấy, June! Tớ căm ghét cậu! - Amy hét lên.\n" +
                "\n" +
                "Còn gì để nói nữa! June xoe tròn đôi mắt ướt đẫm nhìn sững Amy. Amy quay phắt đi, đừng đừng bước ra khỏi phòng June, kéo cánh cửa đóng sầm lại sau lưng mình. Chiếc bình gốm màu xanh da trời trên kệ lắc lư rồi rơi xuống sàn, vỡ tan thành nhiều mảnh. Nước mắt giàn giụa, June quỳ xuống sàn nhặt lên từng mảnh vỡ. Thế là hết. Hết rồi những tiếng cười khúc khích trong veo của hai đứa. Hết rồi những buổi tán gẫu, những bữa tiệc kéo dài phải ngủ lại nhà nhau. Và cũng hết rồi những lần hai đứa huyên thuyên bất tận trên điện thoại... Hết thật rồi! Tình bạn 10 năm đã vỡ tan tành như chiếc bình mà June đã nâng niu như báu vật suốt bao nhiêu năm, chiếc bình tượng trưng cho tất cả những gì tuyệt vời nhất của tình bạn.\n" +
                "\n" +
                "Nỗi đau mất đi người bạn thân nhất, mất đi người mình tin tưởng nhất còn đau xót hơn cả việc bị ngàn vết dao đâm. June gục người trên ghế nức nở. Đây không phải là chuyện cãi nhau ngớ ngẩn nhưng đôi lúc vẫn xảy ra giữa cô và Amy. Lần này quá đỗi trầm trọng và khó lòng hòa giải. Một cảm giác trống trải khủng khiếp chiếm ngự trái tim June. Cô biết tình cảm gắn bó giữa họ chỉ còn là con số không to tương. Cô cũng biết chẳng cách nào có thể hàn gắn lại được. Tất cả đã kết thúc.\n" +
                "\n" +
                "Những ngày sau đó, khi gặp nhau ở trường, cả June và Amy đều lạnh lùng và cư xử với nhau như người xa lạ. Không lâu sau lần cãi vã đó, Amy chia tay người bạn trai của cô. June biết lúc ấy Amy đang cần mình nhưng cả hai đều bương bỉnh, tiếp tục giữ thái độ băng giá và xa cách với nhau. Amy không tha thứ cho những lời kết tội “độc ác” của June. Và cả June, cô cũng không tìm được trong trái tim nguội lạnh của mình một chút hơi ấm nào để có thể tha thứ cho Amy. vết thương thể xác và nỗi đau tinh thần đều cần đến thời gian để chữa lành. Cũng giống như chiếc bình gốm vậy. Những mảnh vỡ của nó vẫn nằm nguyên trong ngăn kéo của June. Dau rằng có thể gắn chúng lại với nhau, và dù cẩn thận đến đâu, những vết nứt vẫn còn đó. Một chiếc bình đã vỡ không bao giờ có thể lấy lại sự nguyên vẹn như trước được.\n" +
                "\n" +
                "Một năm trôi qua. Đến ngày sinh nhật của June, thay vì vui sương và hạnh phúc, June lại thấy buồn. Cô nhớ lại ngày sinh nhật lần thứ 14 của mình, một tháng trước khi cuộc cãi vã nghiêm trọng xảy ra. Ngày hôm đó thật tuyệt; cô và Amy đã rất vui vẻ bên nhau. Họ cứ khúc khích cười mãi về những điều chẳng đâu vào đâu rồi lao vào giành ăn với nhau. Họ đã cùng thề nguyền rằng tình bạn của họ sẽ mãi mãi không bao giờ đổi thay. Những giọt nước mắt thấm đẫm sự ngọt ngào lẫn đắng cay dâng lên trong khóe mắt của June. Cô vẫn còn nhớ hình ảnh cô bé Amy 4 tuổi đang chìa chiếc bình màu xanh về phía cô.\n" +
                "\n" +
                "Có tiếng chuông reo. June bật dậy và chạy ra cửa. Cô đang chờ người chị họ của mình đến. Cánh cửa mở ra. June cứng đờ cả người. Amy đang đứng tại ngưỡng cửa, tay cầm một gói quà nhỏ.\n" +
                "\n" +
                "- Tớ chỉ muốn nói rằng tớ...\n" +
                "\n" +
                "Hai người bạn thân cũ nhìn nhau, cảm xúc của cả hai đang phản chiếu trên gương mặt của nhau.\n" +
                "\n" +
                "- Ch... ú... c si... nh nhật vui vẻ, June.\n" +
                "\n" +
                "Cuối cùng thì Amy cũng lắp bắp xong đủ câu. Cô giúi món quà vào tay June rồi chạy nhanh ra đường. June cảm thấy có điều gì đó thôi thúc mình đuổi theo Amy, nhưng cô vẫn đứng yên. Thay vào đó, cô nhẹ nhàng khép cửa lại.\n" +
                "\n" +
                "Về đến phòng mình, June ngồi xuống giường và mở món quà ra. Đó là một chiếc vòng đeo tay. Đính vào đó là một mảnh giấy ghi hàng chữ: “June thân mến, Chúc Mừng Sinh Nhật thứ 15. Amy”, và phía cuối là câu tái bút “Tớ xin lỗi”. Chỉ vỏn vẹn có ba từ. Ba từ đơn giản mà đong đầy niềm vui trong trái tim June. Cô nhấc điện thoại và gọi Amy. Cùng lúc trong đầu cô nhắc mình là phải hàn gắn lại chiếc bình vỡ. Cho dù nó sẽ không bao giờ có thể hoàn hảo như cũ, nhưng một chiếc bình không hoàn hảo vẫn tốt hơn một chiếc bình vỡ nát.',1,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bộ đồ của ba','Lúc nhỏ, bộ đồ ba mặc luôn khiến tôi thấy sượng sùng. Tôi muốn ba ăn mặc giống mấy vị bác sĩ, luật sư chứ không như cách tôi trông thấy ba vào những sáng oi bức khi ba thức dậy sớm để chiên trứng cho tôi và mẹ.\n" +
                "\n" +
                "Ba ưa mặc chiếc quần jeans cũ mèm, với những dấu dao nhíp ở đũng quần, và chiếc áo vải với thật nhiều móc khóa, gài đủ thứ bút viết, thuốc lá, mắt kính, cờ-lê, tuốc-nơ-vít ở các túi. Giày của ba là loại có mũi bằng thép, rất khó cởi ra nên tôi thỉnh thoảng cởi giày giùm ba mỗi khi ông đi sửa máy lạnh về. Mà nghề nghiệp của ba cũng làm tôi thấy xấu hổ ghê gớm.\n" +
                "\n" +
                "Tuy vậy, vì hãy còn là con nít nên tôi thường lén vào phòng ba, bắt chước mặc đồ của ba và săm soi trước gương. Trí tưởng tượng của tôi biến áo ba thành áo choàng của vua, và dây thắt lưng thành bao súng của lính. Tôi thường mặc áo lót của ba đi ngủ. Chính nhờ cái mùi mồ hôi quen thuộc trên cổ áo ba mà tôi trấn át được nỗi sợ bóng tối của mình. Nhưng đến mấy năm gần đây tôi bắt đầu ước chi ba bán quách mớ quần jeans đi để đổi lấy quần kaki và thay những đôi giày cổ lỗ sĩ bằng giày đế phẳng hợp thời trang hơn. Tôi cũng thôi không mặc đồ ba khi đi ngủ. Và cuối cùng thì mơ về một người cha khác.\n" +
                "\n" +
                "Tôi đổ lỗi cho cách ăn mặc của ba đã gây nên những thất bại trong đời mình. Khi bị bọn con trai bắt nạt, tôi cầu mong chúng nhìn thấy ba đội nón cao bồi, cởi trần và dẫn chó đi dạo. Tôi cảm tưởng như bọn con gái cười nhạo tôi vì thấy ba tôi mang đôi giày đen xì tự xén cỏ. Gia đình bọn nó thuê người khác cắt tỉa bãi cỏ (tôi tin chắc là họ ăn mặc cũng đẹp hơn ba tôi); trong khi ba tụi nó thảnh thơi dạo du thuyền trên vịnh, diện áo len màu vàng chanh và đi giày xăng-đan đắt tiền.\n" +
                "\n" +
                "Ba chỉ mua có hai bộ đồ vét trong đời. Ba thích ăn mặc sao cho thoải mái để có thể dễ dàng chui xuống gầm xe. Thế nhưng, vào trước ngày kỉ niệm 20 năm ngày cưới của ba mẹ, ba cùng tôi tới tiệm Sears - cửa hàng quần áo nổi tiếng trong vùng. Suốt buổi trưa ba thử hết bộ này đến bộ kia. Mỗi bộ, ba đều bước đến trước gương, mỉm cười và gật đầu, hỏi giá rồi lại đi tìm bộ khác. Có lẽ ba thử đến cả chục bộ trước khi lái xe qua một cửa hàng giảm giá và mua ngay một bộ mà chẳng cần phải thử. Tối hôm đó, mẹ tôi mãi xuýt xoa là bà chưa từng thấy người đàn ông nào đẹp trai hơn thế.\n" +
                "\n" +
                "Song, hôm ba mặc bộ đồ ấy đi dự lễ phát thưởng lớp 8 của tôi thì tôi ước gì ba ở nhà còn hơn. Sau buổi lễ (tôi được chọn là Học sinh Ưu tú toàn diện), ba vừa thay bộ đồ bạc màu vừa khen ngợi thành tích của tôi. Khi ba vào ga-ra để rửa xe, tôi đánh bạo nói hết với ba về điều bị coi như sai trái đã sỉ nhục tôi ở tuổi 14.\n" +
                "\n" +
                "- Tại sao ba không ăn mặc “tử tế” như ba của mấy đứa bạn con? - Tôi chất vấn.\n" +
                "\n" +
                "Ba sửng sốt nhìn tôi với ánh mắt đau buồn, cố tìm câu trả lời. Rồi trước khi đi khuất vào ga-ra ba nói:\n" +
                "\n" +
                "- Ba thích bộ đồ của mình.\n" +
                "\n" +
                "Đến khi chính chắn hơn, tôi nghiệm ra rằng bọn con gái tránh né tôi không phải vì ba tôi, mà chính vì tôi, con trai của ông. Tôi nhận ra câu nói của ba tối hôm đó rõ ràng hàm ý là: “Có những thứ quan trọng hơn quần áo bên ngoài; và ba không thể tiêu phí đồng xu nào cho bản thân bởi vì con cần nhiều thứ”. Ba chẳng cần nói thêm lời nào, nhưng tôi hiểu ba muốn nói: “Ba hy sinh để cuộc đời con sau này sẽ khá hơn cuộc đời ba”\n" +
                "\n" +
                "Lễ tốt nghiệp trung học của tôi, ba đến dự trong bộ đồ mẹ mới mua hồi sáng sớm. Không hiểu sao ba có vẻ cao ráo đẹp trai và bệ vệ hơn những ông bố khác. Khi ba đi ngang, họ nhường lối cho ba - dĩ nhiên không phải vì bộ đồ mà vì con người ba. Nhận thấy sự tự tin trong dáng vẻ đường hoàng và niềm tự hào trong mắt ba, các bác sĩ và luật sư cư xử với ba thật lịch sự và trân trọng. Sau đó về nhà, ba cất kỹ bộ đồ tầm thường nhất của tiệm Sears ấy vào tủ. Và mãi cho đến lễ tang của ba, tôi không bao giờ trông thấy nó một lần nào nữa!\n" +
                "\n" +
                "Tôi không biết ba đã mặc đồ gì khi mất. Nhưng lúc ấy ba đang làm việc nên ắt hẳn là ba đang mặc bộ đồ ưa thích của mình. Điều đó an ủi tôi nhiều lắm. Mẹ định tẩm liệm ba trong bộ đồ của tiệm Sears, nhưng tôi thuyết phục mẹ gởi đến nhà tang lễ cái quần jeans cũ, chiếc áo vải và đôi giày sờn mép của ba.\n" +
                "\n" +
                "Buổi sáng hôm tang lễ, tôi lấy dao nhíp đục một lỗ trên dây thắt lưng của ba cho nó vừa với eo mình. Xong, tôi mặc bộ đồ tiệm Sears của ba vào. Thu hết can đảm, tôi nhìn mình trong gương. Đó! Ngoại trừ bộ đồ, dáng vẻ tôi mới nhỏ bé và tầm thường làm sao. Một lần nữa, như thời thơ ấu, bộ đồ lại lùng thùng phủ lên thân hình còm nhom của tôi. Mùi của ba lại phả lên mơn trơn khuôn mặt tôi, nhưng không thể nào an ủi tôi được. Tôi không chắc lắm về vóc người của ba - tôi đã không còn là thằng bé nông nổi từ lâu rồi. Đứng lặng trước gương, nước mắt dâng trào, tôi cố tưởng tượng ra “mình sẽ như thế nào trong quãng đời sau này” - những ngày tôi sẽ lớn lên trong bộ đồ của ba.',2,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Khi bạn vội vã','(Chú thích: Thời điểm trong câu chuyện là năm 1945, khi Mỹ thả bom nguyên tử xuống thành phố Hiroshima của Nhật Bản. )\n" +
                "\n" +
                "Hai cha con nhà nọ sinh sống bằng nghề làm nông trên một mảnh đất nhỏ ở miền quê. Mỗi năm, họ lại đánh xe bò nhiều đợt lên thành phố gần đó để bán rau quả, những thứ họ tự tay trồng. Ngoại trừ việc cùng danh tánh và sống chung dưới một mái nhà, hai cha con họ hầu như chẳng có điểm gì giống nhau. Người cha luôn bình tâm trước mọi việc còn người con trai thì lúc nào cũng vội vàng.\n" +
                "\n" +
                "Một buổi sáng tinh mơ nọ, hai cha con thức dậy, chất hàng lên chiếc xe bò để bắt đầu một cuộc hành trình dài như mọi khi. Anh con trai tính trong đầu rằng nếu họ đi với tốc độ nhanh hơn và không nghỉ qua đêm, chỉ sáng sớm hôm sau họ sẽ tới được chợ. Thế là anh dùng roi liên tục thúc con bò, hối nó bước mau hơn.\n" +
                "\n" +
                "- Từ từ thôi, con ạ! - Người cha bảo - Từ tốn sẽ giúp con sống lâu hơn đấy.\n" +
                "\n" +
                "- Nhưng nếu chúng ta đến chợ sớm hơn những người khác, chúng ta sẽ có nhiều cơ hội bán hàng giá cao hơn. - Anh con trai cãi.\n" +
                "\n" +
                "Người cha không đáp. Ông kéo sụp chiếc nón xuống che mặt và ngủ tại chỗ của mình. Thấy thế anh con trai càng bực mình và khó chịu, anh cố thúc con bò đi nhanh hơn nữa.\n" +
                "\n" +
                "Bốn giờ sau, họ đi ngang qua một ngôi nhà nhỏ. Người cha thức giấc, mỉm cười và nói:\n" +
                "\n" +
                "- Tới nhà chú con rồi. Chúng ta ghé vào hỏi thăm chú ấy một tiếng.\n" +
                "\n" +
                "- Nhưng chúng ta đã trễ mất gần một giờ rồi. - Con trai ông càu nhàu.\n" +
                "\n" +
                "- Trễ thêm vài phút nữa cũng chẳng sao. Chú và bố là chỗ ruột thịt, có mấy khi gặp được nhau đâu. - Người cha chậm rãi đáp. Rồi họ dừng lại và ghé vào ngôi nhà.\n" +
                "\n" +
                "Chàng trai trẻ càng sốt ruột và tức tối khi thấy cha và chú ngồi huyên thuyên cười nói. Gần một tiếng sau, hai cha con anh từ giã người chú và tiếp tục lên đường. Lúc này, đến phiên người cha cầm lái. Khi đến một ngã ba, người cha quẹo xe sang phải:\n" +
                "\n" +
                "- Đường bên tay trái ngắn hơn mà bố - Người con nói.\n" +
                "\n" +
                "- Bố biết, nhưng đường bên tay phải đẹp hơn nhiều.\n" +
                "\n" +
                "- Chẳng lẽ bố không biết quý thời giờ à? - Chàng trai trẻ mất kiên nhẫn.\n" +
                "\n" +
                "- Ô, bố quý thời giờ lắm chứ! Chính vì thế bố mới muốn ngắm nhìn cảnh đẹp và tận hưởng trọn vẹn mỗi giây phút.\n" +
                "\n" +
                "Con đường mà người cha đi có nhiều khúc uốn quanh, băng xuyên qua những đồng cỏ thật đẹp mọc đầy hoa dại và có cả một dòng suối mát trong chảy dọc theo - thế nhưng người con trai đã để lỡ mất dịp ngắm nhìn phong cảnh đẹp ấy. Anh ngồi nhấp nhỏm bên trong xe, lòng bồn chồn và hết sức lo lắng vì sợ đến trễ. Anh cũng không nhận thấy cảnh hoàng hôn hôm ấy mới đẹp làm sao!\n" +
                "\n" +
                "Trời sập tối, hai cha con đến một nơi trông như một khu vườn khổng lồ đầy hương sắc. Người cha khoan khoái hít thở hương thơm làm xao xuyến lòng người của những bông hoa, lắng nghe tiếng suối róc rách và đô xe lại.\n" +
                "\n" +
                "- Chúng ta sẽ ngủ lại đây. - Ông khoan khoái nói.\n" +
                "\n" +
                "- Từ giờ trở về sau con không bao giờ đi cùng với bố nữa. - Anh con trai tức tối nói - Bố thì chỉ thích ngắm hoàng hôn và xem hoa hơn là kiếm tiền!\n" +
                "\n" +
                "- Tại sao lại không như thế chứ, đó chẳng phải là những điều đẹp nhất mà từ trước đến giờ con vẫn nói đấy sao?\n" +
                "\n" +
                "Vài phút sau, ông thiếp vào giấc ngủ. Trong khi con trai ông nhìn mãi những ngôi sao lấp lánh trên bầu trời, mong cho đêm chóng qua. Đêm như dài vô tận và người con trai chẳng hề chợp mắt.\n" +
                "\n" +
                "Trước lúc mặt trời mọc, chàng trai trẻ nhanh chóng đánh thức cha anh dậy. Họ lại tiếp tục đi. Sau khi đi được khoảng một dặm, tình cờ họ gặp một người nông dân đi đường - một người xa lạ - đang cố kéo chiếc xe ra khỏi một vũng lầy.\n" +
                "\n" +
                "- Chúng ta giúp ông ấy một tay đi nào. - Người cha già thì thầm.\n" +
                "\n" +
                "- Để mất thời gian nữa à? - Chàng trai như muốn nổi đóa lên.\n" +
                "\n" +
                "- Con bớt căng thẳng một chút đi, có thể chính con cũng đang bị kẹt vào một vũng lầy nào đó. Chúng ta nên giúp đỡ người khác khi họ cần - đừng quên điều đó con ạ!\n" +
                "\n" +
                "Anh con trai dừng xe mà trong lòng hết sức tức giận.\n" +
                "\n" +
                "Khi họ giúp người nông dân kia kéo được chiếc xe khỏi chỗ lầy thì đã gần tám giờ sáng. Đột nhiên, có một vùng ánh sáng rất lớn lóe lên như muốn tách đôi bầu trời ra. Sau đó là một âm thanh nghe như tiếng sấm. Ở xa phía bên kia ngọn đồi, bầu trời trở nên tối đến.\n" +
                "\n" +
                "- Chắc là trong thành phố có mưa dông lớn. - Người cha đoán.\n" +
                "\n" +
                "- Nếu chúng ta nhanh chân hơn, có lẽ giờ này chúng ta đã bán gần hết hàng rồi - Người con lầm bầm.\n" +
                "\n" +
                "- Bình tĩnh đi... con sẽ sống lâu hơn, và con sẽ tận hưởng cuộc sống được nhiều hơn. - ông già nhẹ nhàng khuyên nhủ con mình.\n" +
                "\n" +
                "Khi hai cha con ông đến được ngọn đồi mà trông xuống sẽ thấy toàn cảnh thành phố, trời đã xế chiều. Họ dừng lại và nhìn xuống phía bên dưới một lúc lâu. Không ai nói với nhau một lời nào. Cuối cùng, chàng trai trẻ đặt tay lên vai cha anh rồi nói:\n" +
                "\n" +
                "- Con đã hiểu những lời bố nói rồi.\n" +
                "\n" +
                "Họ quay chiếc xe lại và bắt đầu trở về nhà, rời xa cái thành phố có tên là Hiroshima của Nhật Bản.',3,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bài học về cách chấp nhận','Mỗi lần thất vọng hay gặp thất bại trong cuộc sống, tôi lại nghĩ đến câu chuyện của một cậu bé gần nhà.\n" +
                "\n" +
                "Ngày đó, cậu bé đang tranh tài với các bạn cùng lớp cho một vai diễn trong vở kịch của trường. Mẹ em nói với tôi rằng em đã đặt hết tâm sức vào vai diễn thử này, mặc dù trong thâm tâm bà biết con trai mình không có năng khiếu diễn kịch. Đến ngày nhà trường quyết định chọn ai vào vai, tôi theo mẹ em đến trường để đón em sau giờ tan học.\n" +
                "\n" +
                "Vừa nhìn thấy mẹ, em chạy vội ngay đến, đôi mắt sáng long lanh ngập tràn hãnh diện và thích thú:\n" +
                "\n" +
                "- Mẹ ơi, mẹ đoán thử xem nào?\n" +
                "\n" +
                "Em la toáng lên và không thể chờ được, bằng giọng hổn hển, xúc động, em nói luôn câu trả lời mà sau này trở thành bài học cho tôi:\n" +
                "\n" +
                "- Con được cô chọn là người vỗ tay và reo hò, mẹ ạ!',4,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Người chia sẻ với người khác nhiều nhất','Tình yêu là tất cả mọi điều. Đó là chìa khóa của cuộc đời và ảnh hưởng của tình yêu làm lay động cả thế giới\n" +
                "\n" +
                "- Khuyết danh\n" +
                "\n" +
                "Một thầy giáo lớn tuổi đã kể lại cuộc thi mà có lần ông được mời làm giám khảo. Mục đích của cuộc thi là tìm xem đứa trẻ nào có lòng quan tâm đến người khác nhất. Người đoạt giải cuộc thi này là một cậu bé mới bốn tuổi.\n" +
                "\n" +
                "Gần nhà cậu bé có hai vợ chồng già luôn yêu thương và nương tựa lẫn nhau. Cho đến một ngày kia, khi bà cụ qua đời, ông cụ buồn đau khôn xiết. Nhìn thấy ông cụ đau đớn, cậu bé đi qua nhà và leo vào ngồi trong lòng ông cụ, và cứ ngồi yên ở đó. Khi mẹ cậu bé hỏi cậu đã nói gì để an ủi ông cụ, cậu bé trả lời:\n" +
                "\n" +
                "- Con chẳng nói gì cả, con chỉ giúp cho ông khóc được thôi mà.',5,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đôi mắt','Có một cô gái không may bị mù, quen biết một chàng trai, 2 người cùng yêu nhau, đến một ngày cô gái nói với chàng trai: “Khi nào em nhìn thấy được thế giới, em sẽ lấy anh”. Rồi đến một ngày kia cô gái được phẩu thuật mắt và cô đã nhìn thấy được ánh sáng. Chàng trai hỏi: “Bây giờ em đã thấy được cả thế giới, em sẽ lấy anh chứ?”\n" +
                "Cô gái bị ngẩn ngơ choáng váng khi thấy chàng trai cũng bị mù như mình. Cô ta từ chối anh. Chàng trai ra đi trong nước mắt và nhắn lại rằng: “Hãy giữ gìn cẩn thận đôi mắt của mình em nhé, vì đó là món quà cuối cùng anh có thể tặng em”.',6,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Điện thoại','Nhà không có điện thoại, anh Hai đi làm xa muốn thăm Mẹ phải gọi nhờ nhà hàng xóm. Người hàng xóm không vui lòng nhưng chẳng nói ra. Anh Hai ngại nên những cuộc gọi về cứ thưa dần.\n" +
                "Mẹ dành dụm tiền, nhà mắc được điện thoại. Cũng có khi do bận việc nên cả tuần anh Hai mới gọi về một lần. Từ ngày nhà có điện thoại Mẹ ít đi đâu, làm gì cũng loay hoay bên chiếc máy. Có người hỏi lý do, Mẹ nói: “Sợ thằng Hai gọi về mà không gặp được”.\n" +
                "\n" +
                "Võ Thành An\n" +
                "********************',7,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Nghịch lý','Thanh minh. Bàn chuyện cải mộ Mẹ, anh Hai nói:\n" +
                "– Tôi góp một phần.\n" +
                "– Tôi một phần.\n" +
                "– Tôi cũng một phần.\n" +
                "Thím Tư chen vào, như đùa như thật:\n" +
                "– Chú Út hai phần mới phải. Anh Tư đâu hưởng gì đâu?!\n" +
                "Chợt nhớ lúc nhỏ, mấy anh em ngủ chung với Mẹ. Đêm, muỗi vào mùng cắn Mẹ. Mẹ không đập, sợ hụt, cứ để muỗi cắn Mẹ no rồi sẽ không cắn các con.\n" +
                "Ôi! Tình yêu của Mẹ là thế. Có chia phần bao giờ đâu!\n" +
                "\n" +
                "Văn Triều\n" +
                "********************',8,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tóc sâu','Sáu tuổi. Tôi vọc tay trong vườn tóc ngoại, reo vang: “Con tìm được sợi trắng rồi!”.\n" +
                "Mười tuổi. Tôi cột – mở búi tóc của ngoại, phụng phịu: “Mấy sợi bạc con nhổ hết hồi hôm kia, bữa nay lại chui ra nữa!”.\n" +
                "Mười lăm tuổi. Tôi vừa chạy ra cửa vừa nài nỉ: “Cho con đi chơi một chút đi ngoại. Lát nữa hãy nhổ tóc sâu”.\n" +
                "Mười tám tuổi. Tôi nhìn lên mái tóc ngoại trắng phơ, bất động trong bức ảnh cao cao, rưng rưng thắp một điều ước.\n" +
                "\n" +
                "Song Khê\n" +
                "********************',9,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Tiền mừng tuổi','Năm bảy tuổi, Mẹ bảo đưa tiền Mẹ cất cho… Nó đếm mấy chục ngàn tiền lì xì rồi miễn cưỡng đưa Mẹ cất giùm, vì trước kia không bao giờ thấy Mẹ trả lời.\n" +
                "Năm mười tuổi, nó lén cất tiền không cho Mẹ biết.\n" +
                "Mười tám tuổi, nó mang nỗi nhớ quê hương bước vào đại học ở tận miền trong xa xôi.\n" +
                "Tết. Ký túc xá vắng hoe. Phương Bắc xa xôi nó không về được. Nó nằm co trên giường cầm giấy nhận tiền của Mẹ mà thấy ân hận, xót xa.\n" +
                "\n" +
                "Trương Đình Dạ Vĩnh\n" +
                "*******************',10,7)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Khóc','Vừa sinh ra đã vào trại mồ côi, trừ tiếng khóc chào đời, chồng tôi không hề khóc thêm lần nào nữa.\n" +
                "Năm hai mươi tuổi, qua nhiều khó khăn anh tìm được Mẹ, nhưng vì danh giá gia đình và hạnh phúc hiện tại, một lần nữa bà đành chối bỏ con. Anh ngạo nghễ ra đi, không rơi một giọt lệ.\n" +
                "Hôm nay 40 tuổi, đọc tin Mẹ đăng báo tìm con, anh chợt khóc. Hỏi tại sao khóc. Anh nói:\n" +
                "– Tội nghiệp Mẹ, 40 năm qua chắc Mẹ còn khổ tâm hơn anh.\n" +
                "\n" +
                "Bùi Phương Mai\n" +
                "********************',11,7)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, ' Nói dối','Ngày đó nhà nghèo Cha mất, Mẹ tần tảo nhưng không đủ ăn. Để con có bữa ngon, Mẹ gởi con về giỗ họ. Giữa đám cúng đông vui, chẳng ai đoái hoài, con bơ vơ lạc lõng… Về nhà Mẹ hỏi, con né tránh: “Dạ vui! Cô bác mừng con…!!!”.\n" +
                "Lớn lên, con đi làm xa, tạm gọi là thành đạt. Ngày giỗ họ con về cùng con trẻ, mọi người vui gặp gỡ, chăm sóc đủ điều, từ miếng ăn, chiếc bánh…\n" +
                "Về nhà nhìn ảnh Mẹ con thấy lòng rưng rưng.\n" +
                "\n" +
                "D.A.D\n" +
                "********************',1,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chung riêng','Chung một con ngõ hẹp, hai nhà chung một vách ngăn. Hai đứa chơi thân từ nhỏ, chung trường chung lớp, ngồi chung bàn, đi về chung lối. Chơi chung trò chơi trẻ nhỏ, cùng khóc cùng cười, chung cả số lần bị đánh đòn do hai đứa mãi chơi. Đi qua tuổi thơ với chung những kỷ niệm rồi cùng lớn lên…\n" +
                "Uống chung một ly rượu mừng, chụp chung tấm ảnh… cuối cùng, khi anh là chú rễ còn em chỉ là khách mời. Từ nay, hai đứa sẽ không còn có gì chung nữa, anh giờ là riêng của người ta…\n" +
                "\n" +
                "Nga Miên\n" +
                "********************',2,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Vợ chồng','Mỗi lần du lịch, anh vẫn bật cười vì tính nhát gan của chị. Xe qua đèo: sợ. Lên núi cao: sợ. Biển sóng lớn: sợ. Những lúc ấy, anh lại ôm lấy chị vỗ về:\n" +
                "– Đừng sợ, có anh đây. Em hãy can đảm lên nào!\n" +
                "Công ty phá sản. Từ cương vị giám đốc, anh quay về với hai bàn tay trắng. Anh hốc hác, suy sụp. Chị dịu dàng ôm anh vào lòng, xoa xoa mái tóc:\n" +
                "– Đừng tuyệt vọng, anh còn có em mà. Hãy can đảm nhé anh!\n" +
                "Tùy Nghi\n" +
                "********************',3,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đi thi','Chị Hai đi thi đệ thất. Ba thức dậy từ tờ mờ chở chị đi trên chiếc xe đạp cũ. Chị Hai đậu thủ khoa. Má bảo: “Nhờ Ba mầy mát tay”. Từ đó, lần lượt tới anh Ba rồi cô Út – cấp II, cấp III, tú tài, đại học. Đứa nào cũng một tay Ba dắt đi thi. Giờ cả ba đều thành đạt.\n" +
                "…Buổi sáng trời se lạnh. Ba chuẩn bị đi thi “Hội thi sức khoẻ người cao tuổi”. Má nhìn Ba ái ngại.\n" +
                "– “Để tôi gọi taxi. Tụi nhỏ đều bận cả”, Ba nói.\n" +
                "Buổi tối Má hỏi: “Ông thi sao rồi”. Ba cười xoà bảo: “Rớt”.\n" +
                "\n" +
                "Ngô Thị Thu Vân\n" +
                "********************',4,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Ngày sinh nhật','Chưa đến ngày sinh nhật, còn đến khoảng hai, ba tháng, vợ đã lo nghĩ đến sinh nhật của chồng, con. Rồi chồng lo sinh nhật của vợ, con, và con lo ngày mừng tuổi cho ba, mẹ. Duy chỉ một người, không ai lo đến – ông nội già yếu. Và cho đến một ngày – ngày ông nội mất.\n" +
                "Chồng hỏi vợ: Sinh nhật ông ngày nào?\n" +
                "Vợ hỏi lại chồng: Ngày nào là ngày sinh của ông?\n" +
                "Con cái hỏi cha mẹ: Ông sinh ngày tháng nào?\n" +
                "Vậy là cả con, dâu, cháu, chắt phải đi tìm ngày sinh cha ông trong chứng minh nhân dân đề làm bia mộ cho ông.\n" +
                "Đó là ngày sinh nhật đầu tiên và cuối cùng của ông.\n" +
                "\n" +
                "Diệu An\n" +
                "**********************',5,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chèng ơi! ','Cháu học ở thành phố, lần về thăm quê đem theo cả cô người yêu cùng về. Ngoại mừng ra mặt, lo lắng từ chỗ ngủ, bữa ăn sao cho đứa cháu thật sự vui lòng.\n" +
                "Ở quê câu chữ khó diễn đạt, một tiếng ngoại cũng chèng ơi, hai tiếng cũng chèng ơi… Đứa cháu tỏ vẻ không bằng lòng, kéo ngoại ra hè bảo ngoại đừng nói câu ấy nữa, nghe… quê lắm. Ngoại cười hiu hắt và từ đó ngoại ít nói hơn. Nhớ thủơ nhỏ mỗi khi cháu ngã té đau, biếng ăn một chút là ngoại kêu lên hai tiếng: Chèng ơi! Kêu riết thành quen.\n" +
                "\n" +
                "Võ Thành An\n" +
                "*******************',6,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Người cha ','Nhà có cậu con trai duy nhất ba cưng. Lớn lên con trai với ba như người bạn tâm tình, đi đâu cũng đi cùng, cả khi ăn sáng, uống cà-phê…\n" +
                "Học xong đại học, con trai thành đạt, lấy vợ.\n" +
                "Bận nọ cùng vợ vào quán nước thấy ba ngồi một mình, con trai cùng vợ đến chào, ba vui ra mặt bảo ngồi cùng ba đãi.\n" +
                "Bây giờ con trai mới hiểu, từ khi mình lấy vợ ba vẫn hay đi đâu đó một mình. Mẹ trách phải: “Con trai dễ quên cha mẹ khi… lấy vợ”\n" +
                "\n" +
                "Võ Thành An\n" +
                "********************',7,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mùa thi','Năm tôi thi tốt nghiệp, bấy giờ gọi tú tài, ba đạp xe hơn chục cây số đón tôi ở trường thi cốt đề hỏi: “Con làm bài tốt không?” Sợ ba nhọc lòng tôi nói: “Ba ở ngoài này, có khi con lại lo, không làm bài được”.\n" +
                "Buổi thi cuối, ra cổng không thấy ba, hỏi chú Bảy còi: “Ba con có đến không?” Chú đưa tay chỉ cây bàng phía xa mươi mét bảo: “Ổng ở đằng kia, tao biểu đến ổng không chịu”.\n" +
                "\n" +
                "Võ Thành An\n" +
                "********************',8,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'AI MỚI LÀ KẺ NGU?','Một ông thầy giáo mới dạy nhận ra rằng trong lớp có một cậu bé luôn luôn bị chửi là ngu. Trong giờ ra chơi ông hỏi nhóm bạn lý do.\n" +
                "\n" +
                "– Thì nó là thằng ngu thật mà thầy. Nếu mà đưa cho nó đồng xu to 5 rúp và đồng xu nhỏ 10 rúp, thì nó sẽ chọn đồng 5 rúp, vì nó nghĩ đồng 5 rúp có kích thước to hơn thì là tốt hơn.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Đây, thầy nhìn nhé. Một bạn trong nhóm giơ 2 đồng xu và cho cậu kia chọn. Và cậu vẫn chọn đồng 5 rúp như trước.\n" +
                "\n" +
                "Thầy giáo ngạc nhiên hỏi:\n" +
                "\n" +
                "– Sao em lại chọn 5 rúp mà không chọn 10 rúp?\n" +
                "\n" +
                "– Thầy nhìn này, đồng 5 rúp to hơn mà.\n" +
                "\n" +
                "Tan trường, thầy đến chỗ cậu bé hỏi lại:\n" +
                "\n" +
                "– Chẳng nhẽ em không thể hiểu được đồng 5 rúp chỉ to hơn về mặt kích thước, nhưng đồng 10 rúp thì em có thể mua được nhiều thứ hơn?\n" +
                "\n" +
                "– Nếu em lấy 10 rúp thì lần sau bọn nó sẽ không cho em nữa… Cậu bé trả lời.\n" +
                "\n" +
                "Bài học rút ra: Chắc chắn khi đọc đến đây bạn sẽ thấy cậu bé kia tỏ ra ngờ nghệch mà không hẳn là vậy. Người ta thường nói: “Ngu mà tỏ ra nguy hiểm thì không có gì phải sợ, đáng sợ là người nguy hiểm mà tỏ ra ngu”. Vì vậy, đừng xem thường người đối diện với bạn. Bởi người đối diện với bạn chưa chắc đã ngu như bạn nghĩ… Truyện cực ngắn về đồng xu khiến bạn xem xét lại cách nhìn đối với người đối diện…',9,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'NGƯỜI TIỀU PHU VÀ HỌC GIẢ','Tiều phu cùng học giả đi chung một chiếc thuyền ở giữa sông. Học giả tự nhận mình hiểu biết sâu rộng nên đề nghị chơi trò đoán chữ cho đỡ nhàm chán, đồng thời giao kèo, nếu mình thua sẽ mất cho tiều phu mười đồng. Ngược lại, tiều phu thua sẽ chỉ mất năm đồng thôi. Học giả coi như mình nhường tiều phu để thể hiện trí tuệ hơn người.\n" +
                "\n" +
                "Đầu tiên, tiều phu ra câu đố:\n" +
                "\n" +
                "“Vật gì ở dưới sông nặng một ngàn cân, nhưng khi lên bờ chỉ còn có mười cân?”.\n" +
                "\n" +
                "Học giả vắt óc suy nghĩ vẫn tìm không ra câu trả lời, đành đưa cho tiều phu mười đồng. Sau đó, ông hỏi tiều phu câu trả lời là gì.\n" +
                "\n" +
                "“Tôi cũng không biết!“, tiều phu đưa lại cho học giả năm đồng và nói thêm:\n" +
                "\n" +
                "“Thật ngại quá, tôi kiếm được năm đồng rồi.” Học giả vô cùng sửng sốt.\n" +
                "\n" +
                "Bài học rút ra: Trong cuộc sống, nhiều người hay tỏ vẻ là mình trí tuệ, thông minh hơn người và tỏ vẻ coi thường những người ít học, học thấp hơn họ. Tuy nhiên đôi lúc, sự tự phụ quá tự tin của họ sẽ khiến họ bị lâm vào những tình huống “dở khóc dở cười”. Họ không biết một điều rằng “thông minh sẽ hại thông minh“, người quá thông minh và tinh tướng nhiều khi sẽ tự hại lấy mình vì quá tự cao. Lẽ vậy ở đời, đừng sợ kẻ thông minh, hãy sợ kẻ ngốc mà tưởng mình thông minh. Và hãy làm một người khiêm tốn đáng được tôn trọng. Truyện cực ngắn về người tiều phu khiến chúng ta phải suy nghĩ về đức tính khiêm tốn.',10,8)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'NHÀ VUA VÀ ĐÔI CHÂN ĐAU','Ngày xưa, có ông vua cai trị ở một đất nước phồn vinh nọ. Một ngày kia, vị vua đi ngao du sơn thủy. Khi quay trở lại hoàng cung, vị vua phàn nàn chân mình rất đau, bởi vì đây là lần đầu tiên vua phải trải qua một cuộc hành trình dài như thế và chặng đường ông đi lại rất gồ ghề, đá lởm chởm.\n" +
                "\n" +
                "Sau đó, vị vua hạ lệnh:\n" +
                "\n" +
                "“Cho bọc tất cả con đường trong đất nước lại bằng da. Điều này sẽ dẫn đến việc phải cần hàng ngàn bộ da bò và một số lượng khổng lồ tiền bạc.”\n" +
                "\n" +
                "Bỗng có một hôm, người vợ của tên hầu nhà vua đã dũng cảm hỏi nhà vua:\n" +
                "\n" +
                "“Tại sao ngài lại tốn một số lượng tiền không cần thiết như thế? Tại sao ngài không dùng một miếng da nhỏ để bọc lại chân của ngài?”.\n" +
                "\n" +
                "Nhà vua ngạc nhiên, nhưng rồi ông cũng đồng ý làm một đôi giày.\n" +
                "\n" +
                "Bài học rút ra: Chuyện cực ngắn trên đây sẽ giúp cho bạn hiểu: Để có một cuộc sống, một nơi chốn hạnh phúc để sống, tốt hơn là bạn nên thay đổi chính mình, suy nghĩ của bạn, trái tim bạn – chứ không phải bắt thế giới thay đổi bởi “Nếu bạn thay đổi, cả thế giới sẽ thay đổi“. Hãy thay đổi chính bạn, bạn sẽ thấy thế giới này đẹp hơn rất nhiều.',11,8)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, ' BÀI HỌC THÀNH BẠI TỪ HƯƠU CAO CỔ ','Mỗi lần một chú hươu con ra đời đều là một bài học. Khi sinh con, hươu mẹ không nằm mà lại đứng, như vậy hươu con chào đời bằng một cú rơi hơn 3m xuống đất và nằm ngay dưới đó. Sau vài phút, hươu mẹ làm một việc hết sức kỳ lạ, đó là đá vào người con mình cho đến khi nào nó chịu đứng dậy mới thôi. Khi hươu con mỏi chân và nằm, hươu mẹ lại thúc chú đứng lên.\n" +
                "\n" +
                "Cho đến khi thực sự đúng được, hươu mẹ lại đẩy chú ngã xuống để hươu con phải nỗ lực tự mình đứng dậy trên đôi chân còn non nớt.',1,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'HAI CON HỔ SỐ PHẬN KHÁC NHAU','Có hai con hổ, một con ở trong chuồng, một con nơi hoang dã.\n" +
                "\n" +
                "Hai con hổ đều cho rằng hoàn cảnh của bản thân mình không tốt, đôi bên đều ngưỡng mộ đối phương, thế là chúng quyết định thay đổi thân phận với nhau. Lúc mới bắt đầu, cả hai đều vô cùng vui vẻ, nhưng không lâu sau đó, hai con hổ đều chết cả: Một con vì đói mà chết, một con u sầu mà chết.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Bài học rút ra: Có những lúc, mọi người nhắm mắt làm ngơ đối với hạnh phúc của chính bản thân mình, để rồi luôn để mắt đến hạnh phúc của những người khác. Thật ra, những gì mà bạn đang có chính là những điều mà người khác phải ngưỡng vọng.\n" +
                "\n" +
                "Cuộc đời là thế, nhiều chuyện xảy ra theo cách không thể ngờ tới, hy vọng sau khi đọc những câu chuyện này, mọi lúc mọi nơi ai cũng có thể tự nhắc nhở bạn thân mình vậy.',2,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mọi Người Điều Có Một Câu Chuyện Trong Cuộc Sống','Một cậu bé 18 tuổi nhìn thấy từ cửa sổ xe lửa và hét lên …\n" +
                "“Bố ơi, hãy nhìn cái cây đi!”\n" +
                "Dad mỉm cười và một cặp vợ chồng trẻ ngồi gần đó, nhìn vào thái độ trẻ con của cậu bé 18 tuổi với sự thương hại, đột nhiên cậu bé lại kêu lên …\n" +
                "\n" +
                "“Bố, nhìn đám mây đang chạy với chúng ta kìa!”\n" +
                "\n" +
                "Cặp vợ chồng không thể cưỡng lại và nói với ông lão …\n" +
                "\n" +
                "“Sao ông không đưa con trai mình đến một bác sĩ tốt?” Ông già cười và nói … “Tôi đã làm và chúng tôi vừa mới đến bệnh viện, con trai tôi đã mù từ lúc sinh ra, nó chỉ nhìn mọi thứ bằng mắt của mình mới hôm nay thôi.”\n" +
                "\n" +
                "Mỗi người trên trái đất này đều có câu chuyện riêng của mình. Đừng đánh giá người khác trước khi bạn thực sự biết rõ về họ. Sự thật có thể làm bạn ngạc nhiên.',3,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chú Lừa Bị Mắc Kẹt Dưới Hố','hú lừa yêu thích của anh nông dân bị rơi vào một vực sâu. Anh ta không thể kéo nó lên dù anh ta cố gắng hết sức. Do đó anh ta quyết định chôn sống nó dù không muốn chút nào.\n" +
                "\n" +
                "Cứ thế, đất được đổ từ trên xuống để lắp chú lừa, mỗi lần đất đổ xuống lưng nó là nó lắc đều và bước lên trên, liên tục liên tục cho đến trưa, chú lừa yêu thích của anh nông dân đang ăn cỏ trên những đồng cỏ xanh.',4,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cọng Dây Thừng Bé Nhỏ Buộc Chân Voi','Khi một người đàn ông đi ngang qua con voi trong sở thú, anh ta đột ngột dừng lại, bối rối bởi thực tế là những sinh vật khổng lồ này chỉ bị giữ bởi một sợi dây nhỏ gắn dưới chân. Rõ ràng là các con voi có thể, bất cứ lúc nào, thoát khỏi sợi dây đó, nhưng vì một lý do nào đó, con voi không làm vậy.\n" +
                "\n" +
                "Anh ta nhìn thấy một huấn luyện viên gần đó và hỏi tại sao những con vật này chỉ đứng đó và không cố gắng trốn tránh. Người quản Tượng nói, “khi chúng còn nhỏ và nhỏ hơn nhiều, chúng tôi sử dụng cùng một sợi dây kích cỡ như thế để buộc chúng, ở tuổi đó, chúng không thể thoát được. Khi chúng lớn lên, chúng tin rằng chúng không thể chạy trốn được.”\n" +
                "\n" +
                "Người đàn ông kinh ngạc. Những con voi này bất cứ lúc nào cũng có thể thoát khỏi họ, nhưng chúng không làm thế!\n" +
                "\n" +
                "Giống như voi, có bao nhiêu người trong chúng ta có một niềm tin rằng chúng ta không thể làm điều gì đó, đơn giản chỉ vì chúng ta đã thất bại trước?\n" +
                "\n" +
                "Thất bại là một phần của học tập, Chúng ta không nên từ bỏ cuộc đấu tranh trong cuộc sống này.',5,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Một Ly Kem','Một cậu bé 10 tuổi bước vào quán cà phê và ngồi bàn. Cô phục vụ đặt ly nước trước cậu ta.\n" +
                "\n" +
                "“Một ly kem táo bao nhiêu tiền vậy cô?”\n" +
                "\n" +
                "“50 xu”, cô trả lời.\n" +
                "\n" +
                "Cậu bé rút tay ra khỏi túi của mình và cẩn thận đếm những đồng tiền trong đó.\n" +
                "\n" +
                "“Còn kem loại thường thì sao?”, Cậu bé hỏi. Một người bàn bên cũng đang muốn gọi món và cô phục vụ bắt đầu thiếu kiên nhẫn.\n" +
                "\n" +
                "“35 xu”, cô tỏ vẽ cộc cằn.\n" +
                "\n" +
                "Cậu bé lại đếm tiền xu. “Hãy cho conly kem loại thường,” cậu bé nói.\n" +
                "\n" +
                "Cô phục vụ mang kem đến, đặt hóa đơn lên bàn và bỏ đi. Cậu bé ăn xong kem, đến quầy trả tiền rồi đi.\n" +
                "\n" +
                "Khi cô hầu bàn trở lại, cô bắt đầu lau dọn bàn và bất ngờ trước những gì cô nhìn thấy.\n" +
                "\n" +
                "Ở đó, đặt ngay ngắn bên cạnh ly kem đã ăn hết, là 15 xu.',6,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Ông Già giữ xe','Ông già giữ xe có xăm một con hổ trên cánh tay. Chỗ giữ xe của ông đông khách đến bực mình. Giá rẻ, không “kỳ thị” xe gì. Nhận hết. Ông thường không từ chối khách giữ xe, vì ai cũng có việc cần mới đi lên cái cơ quan bên hông bãi đó. Nhưng một sáng, ông nói: Cô để xe lên kia giúp tôi. Ông chỉ vào chỗ trống. Cô gái không để xe vào vị trí được chỉ dẫn, mà chỉ de lên lề, xuống và tháo khẩu trang, đóng cốp xe, và hỏi ông phiếu giữ xe. Ông im lặng… Và gầm lên:\n" +
                "- Đi chỗ khác gửi. Đây hết chỗ rồi! \n" +
                "Cô gái không hề kém cạnh, cô hỏi sao không đưa phiếu cho cô. \n" +
                "Ông ngang bướng: \n" +
                "- Cô đi chỗ khác, tôi hết chỗ rồi!\n" +
                "Trong khi đó, bãi xe còn một đoạn dài chưa có xe nào để, và tất nhiên, chỗ ông đã chỉ dẫn cô cũng chưa có ai đậu. \n" +
                "Tôi nghe xong câu chuyện thì đi vào khu xin giấy tờ. Cũng không để ý nhiều.\n" +
                "Cho đến một lần khác, tôi quay lại tòa nhà đó, và đi thẳng xuống hầm để xe vì trời mưa, không đậu xe chỗ ông.\n" +
                "Một hàng xe dài dâng lên liên tục vì ai cũng muốn vào làm giấy tờ, lại giờ cao điểm. Bốn anh thanh niên mặc đồ bảo vệ cao to, còng lưng đẩy từng chiếc xe đậu lung tung vào chỗ. Chỉ 2 phút sau, mọi việc mất kiểm soát, vì tất cả mọi người đều đậu bất cứ chỗ nào mình thích. Cuối cùng, chú bảo vệ già nhất làm việc điều tiết phải la lên: Các anh chị ơi, đậu sát vào vị trí trong vạch dùm tôi, cả ngàn chiếc, anh em xếp sao được.\n" +
                "Mặc kệ. Mọi người chỉ đơn giản là thắng xe, gạt chống, lột áo mưa và bỏ chiếc xe nằm ở bất cứ chỗ nào họ thấy tiện. Trong hầm nóng, 4 anh bảo vệ cúi gằm mặt đẩy, kéo từng chiếc xe vào đúng vạch sơn vàng và thẳng hàng, áo nhễ nhại mồ hôi.\n" +
                "Lúc đó, tôi đã nghĩ đến ông giữ xe có hình xăm bên ngoài và trò ngang bướng của ông ở trên kia. Có những người rất kỳ lạ, họ nghĩ rằng họ bỏ ra 5k-10k tiền giữ xe, và họ có quyền ném xe dưới lề đường, bất chấp tình huống của một bãi giữ xe hàng ngàn chiếc và sự vất vả của người làm công việc này.\n" +
                "Cô gái kia, quen thuộc y như lũ người tôi gặp, họ đang mải mê đi xin giấy tờ. Họ cần o bế một ai khác. Họ không quan tâm đến những người thấp kém, người cởi trần, người mặc áo bảo vệ, người dưới hầm. Họ có 5k - đủ sức chi trả để lên xe xuống ngựa, vứt xe đấy, mặc cho ai phải xoay sở cực khổ thế nào với việc họ phải làm, thế mới đáng số tiền bỏ ra.\n" +
                "5k có đủ một bữa cơm cho người giữ xe không? 5k có đủ để biến một người thành đẳng cấp hơn so với một người khác không? - Hay những người giữ xe là những kẻ không xứng đáng được đối thoại, được tôn trọng, hay đáng đời họ làm giữ xe thì phải đẩy xe, kéo xe chứ, than phiền gì nữa?\n" +
                "Ta quá quen với cách tưởng thưởng cho mình quyền được trèo lên lưng người khác cưỡi vì có đủ tiền bỏ ra mua dịch vụ, hay phải cảm thấy được cưỡi thì mới xứng đáng với số tiền bỏ ra. Ta quên mất cách phải tôn trọng người khác - như người - cũng giống mình.\n" +
                "Họ quên mất rằng, chỉ cần đạp ga xe, chạy nhấn lên 2 giây nữa, vượt qua vạch vàng, và kéo chiếc xe sát vào chiếc bên cạnh, họ đã giúp những người bảo vệ bớt đi bao nhiêu mồ hôi, cơn mệt mỏi, và cả sự ức chế trong không gian ngột ngạt thiếu khí của hầm để xe. Hoặc nếu ai giỏi tưởng tượng hơn, những anh bảo vệ đó không xứng đáng bị đối xử thô thiển như vậy, vì họ đang làm thuê với những đồng lương rẻ mạt và cực nhọc của người lao động tay chân.\n" +
                "Với em khách giữ xe thanh lịch có 5k kiểu vậy, gầm lên và đuổi đi như ông giữ xe già , có lẽ là trò rất bực mình mà ông ấy phải làm, để khỏi phải cầu xin như chú bảo vệ bên dưới hầm, với 1 lũ vô tâm kỳ lạ.',7,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Sự Tích Chiếc Nhẫn In Hình 7 Ngôi Sao','Chuyện kể rằng: ngày xưa ngày xưa, có 1 đôi nam nữ yêu nhau say đắm. Cô gái Hath rất xinh đẹp, thông minh & giàu có. Chàng trai Gimi nghèo khó, chẳng có gì ngoài tình yêu chân thành. Dù vậy, họ yêu nhau và sống hạnh phúc bên nhau.Để làm đẹp mình hơn trong mắt người yêu, một hôm cô gái quyết định vào tiệm duỗi tóc. Khi trở về, Hath xinh đẹp và lộng lẫy gấp ngàn lần hơn. Mọi người đều trầm trồ khen ngợi nàng là người đẹp nhất thế gian. Lời đồn đến tai thần Venus. Nữ thần sắc đẹp rất tức giận vì Hath xinh đẹp hơn mình, nên bắt Hath phải chết.\n" +
                "\n" +
                "Và rồi nàng Hath chết, song sắc đẹp của nàng vẫn không tàn phai. Chàng Gimi đặt nàng nằm trong 1 chiếc quan tài bằng pha lê, và chàng quyết tâm đi đến cùng trơì cuối đất tìm cách cứu nàng. Chàng đi ròng rã ngày này sang tháng khác, vượt qua bao nhiêu khó khăn, đi qua bao miền đất, giúp đỡ biết bao người dọc đường đi. Đến nơi chân trời xa kia, chàng gặp được vị thần Eros. Thần tình yêu cảm động trước chàng, thần chỉ tay lên bầu trời và dặn rằng:\"Ở trong dãy thiên hà xa xôi kia, có 1 chùm sao gồm 7 ngôi sao băng. Con hãy đến đó, và hái cho được 1 ngôi sao băng sáng nhất. Vào ngày cuối cùng của tháng 7, con hãy ném ngôi sao ấy xuống trái đất, người con yêu sẽ tỉnh dậy. Nhưng sau đó, con sẽ phải biến thành 1 ngôi sao để thế chỗ cho ngôi sao băng đó, rồi suốt đời con sẽ chỉ là 1 ngôi sao. Con có chịu không?\"\n" +
                "\n" +
                "Những ai được chết vì yêu là đang sống trong tình yêu, ta không quan tâm chuyện gì xảy ra, chỉ cần nàng được sống, chàng nghĩ. Và chàng tiếp tục lên đường.Chàng đã hái ngôi sao băng sáng nhất, chàng đã chờ đợi ngày ngày để ném nó xuống trái đất. Một ngày dài như một năm khi chờ đợi, chàng không thể chờ thêm được nữa. Chàng đã ném nó xuống trái đất trước 1 ngày. Đêm 30-7 năm đó, khi ngôi sao băng sáng nhất được ném xuống trái đất, gặp lực ma sát cực lớn của bầu khí quyển, nó đã vỡ tung ra thành hàng trăm mảnh nhỏ, làm sáng rực cả một vùng trời. Sau này, người ta gọi đó là mưa sao băng.\n" +
                "\n" +
                "Ở nơi đó, trong chiếc quan tài pha lê tuyệt đẹp, nàng Hath vẫn nằm im, xinh đẹp. Mái tóc nàng mượt mà như suối nước, những ngón tay nàng nhỏ nhắn, mềm mại đến diệu kỳ. Cơ thể nàng vẫn lạnh ngắt. Chỉ 2 dòng nước mắt nóng chảy trên gò má nàng, chảy mãi, chảy mãi. Chàng Gimi giờ trở thành 1 ngôi sao. Vì quá thương nhớ nàng Hath mà chàng không thể thắp sáng nổi chính mình. Chàng dần mờ nhạt nhất trong cả chùm sao, mà sau này người ta gọi là chòm sao tình yêu.\n" +
                "\n" +
                "Ngày nay, mỗi khi gặp mưa sao băng, chúng ta thường mơ ước 1 điều gì đó. Đặc biệt, nếu gặp được mưa sao băng trong đêm 30-7, những người yêu nhau luôn mơ ước mãi mãi không chia lìa. Sau này, khi sắp xếp lại bảng chữ cái, chữ cái đầu tiên của tên 2 người được đặt kề cạnh nhau, theo thứ tự chàng đi trước, nàng theo sau. Mong muốn 1 tình yêu bền lâu, những người yêu nhau cũng thường tặng nhau những chiếc nhẫn in hình 6 ngôi sao băng & 1 ngôi sao cô đơn mờ nhạt. ',8,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Bốn Ngọn Nến','Nếu trái tim con người luôn cháy lên ngọn lửa hy vọng, chúng ta sẽ tìm được những điều tốt đẹp cho cuộc sống như tình yêu, niềm tin và hòa bình.\n" +
                "Trong một căn phòng, không gian tĩnh lặng tới mức người ta có thể nghe thấy tiếng thì thầm của những ngọn nến. Cây nến thứ nhất than vãn: “Ta là biểu tượng của Thái Bình, Hòa Thuận.\n" +
                "Thế nhưng đời nay những cái đó thật chông vênh. Thế giới hiếm khi im tiếng gươm súng, người với người - thậm chí vợ chồng anh em trong một nhà cũng chẳng mấy khi không cãi cọ\". Thế rồi ngọn nến leo lét, ngọn lửa mờ dần cho tới khi ánh sáng lụi tắt hoàn toàn.\n" +
                "Ngọn nến thứ hai vừa lắc vừa kể lể: ''Ta là Niềm Tin. Thế nhưng trong thế giới này hình như ta trở nên thừa thãi, một món xa xỉ. Biết bao kẻ sống theo thời không cần tới niềm tin”. Nói rồi ngọn nến từ từ, tắt tỏa ra một làn khói trắng luyến tiếc.\n" +
                "''Ta là Tình Yêu - ngọn nến thứ ba nói - Nhưng ta không còn đủ sức để tỏa sáng n\n" +
                "Người ta gạt ta ra một bên và không thèm hiểu giá trị của ta. Cứ nhìn thế giới mà xem, không thiếu kẻ quên luôn cả tình yêu đối với những người ruột thịt của mình''. Dứt lời phẫn nộ, ngọn nến vụt tắt.\n" +
                "Căn phòng trở nên tối tăm. Chỉ còn một ngọn nến nằm ở góc xa vẫn tiếp tục phát ra ánh sáng, như ngôi sao đơn độc giữa bầu trời đêm âm u. Bất chợt một cô bé bước vào phòng. Thấy ba ngọn nến bị tắt, cô bé thốt lên: ''Tại sao các bạn không cháy nữa? Cuộc sống này luôn cần các bạn. Hòa Bình, Niềm Tin, Tình Yêu phải luôn tỏa sáng chứ''.\n" +
                "Cây nến thứ tư nãy giờ vẫn lặng lẽ cháy trong góc phòng, đáp lời cô gái: ''Đừng lo. Tôi là Hy Vọng. Nếu tôi còn cháy, dù ngọn lửa rất mong manh, chúng ta vẫn có thể thắp sáng lại Hòa Bình, Niềm Tin và Tình Yêu''.\n" +
                "Mắt cô bé sáng lên. Cô bé dùng cây nến thứ tư - Hy Vọng - thắp sáng trở lại các cây nến khác\n',9,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Trồng răng giả cho mẹ','Có một anh chàng đại gia, mẹ anh đã già, răng đã rụng cả, thế nên anh lái xe đưa mẹ đi trồng răng. Khi vào phòng mạch nha sỹ, người ta bắt đầu giới thiệu các loại răng giả, nhưng người mẹ lại muốn loại rẻ nhất.\n" +
                "\n" +
                "Nha sỹ không chịu thế, ông ấy vừa nhìn người con trai đại gia, vừa kiên nhẫn so sánh răng giả chất lượng tốt và răng giả chất lượng thấp. Thế nhưng điều khiến nha sỹ vô cùng thất vọng đó là người con trai giàu có này lại rất thơ ơ, chẳng đả động gì, chỉ lo gọi điện thoại, hút thuốc lá, hoàn toàn không quan tâm tới những gì ông nói.\n" +
                "\n" +
                "Nha sỹ không thuyết phục được người mẹ nên đã đồng ý yêu cầu của bà. Lúc này người mẹ run run lấy từ trong túi áo ra một cái túi vải, mở từng lớp từng lớp ra, lấy tiền đóng tiền đặt cọc, một tuần sau chuẩn bị đến trồng răng.\n" +
                "\n" +
                "Sau khi họ đi, những người ở phòng mạch bắt đầu mắng chửi người con trai giàu có kia, nói anh ta ăn mặc bóng loáng, hút thuốc đắt tiền, mà không nỡ bỏ tiền trồng một bộ răng tốt cho mẹ.\n" +
                "\n" +
                "Khi họ đang chỉ trích thì không ngờ người con trai giàu có kia quay trở lại, anh nói: “Nha sỹ, phiền ông trồng cho mẹ tôi loại răng sứ tốt nhất, phí tôi sẽ trả, bao nhiêu tiền không quan trọng. Nhưng ông đừng nói sự thật với bà ấy, mẹ tôi là một người cực kỳ tiết kiệm, tôi không muốn làm bà không vui.”\n" +
                "\n" +
                "Cả căn phòng chìm trong im lặng.',10,9)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đồng hồ báo thức','Khi cậu con trai lên giường đi ngủ là 11 giờ tối, bên ngoài cửa sổ tuyết đã rơi. Cậu rúc vào trong chăn, cầm đồng hồ báo thức, nhận ra đồng hồ đã bị đứng rồi, cậu lại quên không mua pin. Trời lạnh thế này, cậu không muốn dậy. Cậu gọi điện thoại đường dài cho mẹ:\n" +
                "\n" +
                "“Mẹ ơi, đồng hồ báo thức của con hết pin rồi, ngày mai con phải dậy sớm đến công ty đi họp, 6 giờ sáng mẹ gọi điện thoại đánh thức con nhé.”\n" +
                "\n" +
                "Giọng của mẹ cậu ở đầu dây bên kia có hơi khàn khàn, có thể là bà đang ngủ dở giấc thì bị cậu đánh thức lúc nửa đêm, mẹ cậu nói: “Được rồi, con ạ.”\n" +
                "\n" +
                "Khi đồng hồ reo lên, cậu đang mơ một giấc mơ đẹp, bên ngoài trời vẫn còn mờ tối. Đầu dây bên kia mẹ cậu nói: “Con này, con mau dậy đi, hôm nay phải đi họp đấy”. Tôi nhấc tay lên xem giờ, mới có 5 giờ 40. Cậu khó chịu kêu lên: “Chẳng phải con nói là 6 giờ sao ạ? Con còn muốn ngủ thêm một lúc nữa, bị mẹ làm tỉnh rồi!”. Đột nhiên mẹ cậu không nói gì nữa, cậu gác máy.\n" +
                "\n.Cậu thức dậy đánh răng rửa mặt rồi ra ngoài. Trời lạnh thật, khắp nơi trên trời dưới đất đâu đâu cũng đầy tuyết. Đứng ở trạm xe buýt, cậu không ngừng dậm dậm chân cho ấm. Bên cạnh cậu có hai cụ già tóc đã bạc trắng. Cậu nghe thấy ông cụ nói với bà cụ: “Bà xem cả đêm bà chẳng ngủ được, sáng sớm đã bắt đầu giục tôi rồi, bây giờ lại phải đợi lâu như thế này”.\n" +
                "\n" +
                "Đúng vậy, chuyến xe đầu tiên phải 5 phút nữa mới đến. Cuối cùng xe cũng đến, cậu lên xe. Người lái xe là một tài xế trẻ tuổi, anh ấy đợi cậu lên xe rồi từ từ lái đi. Cậu nói: “Này, tài xế, ở dưới còn có hai cụ già nữa đấy. Trời lạnh như vậy, người ta đợi xe lâu lắm rồi, sau anh không đợi họ lên xe rồi hẵng lái đi?”.\n" +
                "\n" +
                "Anh chàng tự hào nói: “Không sao, đó là bố mẹ tôi! Hôm nay là ngày đầu tiên tôi lái xe buýt, họ đến xem tôi đấy!”\n" +
                "\n" +
                "Đột nhiên tôi khóc, tôi thấy bố gửi tin nhắn đến: “Con à, mẹ nói là mẹ không tốt. Mẹ cứ ngủ không yên, dậy từ rất sớm, lo con bị trễ họp”.',11,9)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Sư tử, Lừa và Cáo','Chuyện kể rằng, có 3 con vật đi săn cùng nhau, đó là: Sư tử, Lừa và Cáo. Sau khi săn được nhiều thức ăn, Sư tử ra lệnh cho lừa phân chia chiến lợi phẩm. Dĩ nhiên, với bản tính thật thà của mình, lừa ta chia thức ăn thành 3 phần bằng nhau và bảo Sư tử chọn một trong 3 phần đã chia.\n" +
                "\n" +
                "Ngay lập tức, Sư tử vồ lấy và xé xác lừa ra. Sau đó, sư tử tiếp tục ra lệnh cho Cáo chia lại chiến lợi phẩm. Với bản tính tinh ranh của mình, Cáo ta hiểu ra vấn đề nên chỉ lấy một chút cho phần của mình và nhường phần cực lớn cho Sư tử. Thấy vậy, Sư tử vui vẻ nói “Ai đã dạy chú cách phân chia hợp lý thế?”.\n" +
                "\n" +
                "Cáo ta chỉ đáp vỏn vẹn một câu: “Tôi học từ Lừa đấy!”\n" +
                "\n" +
                "10 truyện ngụ ngôn hay và ý nghĩa do BIG.vn tổng hợp\n" +
                "Bài học:\n" +
                "\n" +
                "Thời gian của cuộc đời là quá ngắn so với những bài học hay kinh nghiệm sống mà chúng ta cần tích lũy. Do đó, hãy tiết kiệm thời gian cũng như công sức của mình, bằng cách học hỏi từ những sai lầm và thất bại của người khác mà lưu ý. Điều này sẽ giúp ích rất lớn trong việc đối nhân xử thế trong xã hội và gia đình.',1,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Hai người du khách và chiếc ví','Bạn nghĩ sao về câu “Có phước cùng hưởng, có họa cùng chia!”? Hãy cùng tìm hiểu điều này thông qua bài viết dưới đây do BIG.vn sưu tầm.\n" +
                "\n" +
                "Có 2 người khách bộ hành đang đi chung với nhau trên một con đường. Bỗng nhiên, họ nhặt được một chiếc ví khá to và cứng.\n" +
                "\n" +
                "Một người bảo “Tôi may mắn quá. Chắc chắn bên trong có rất nhiều tiền!”\n" +
                "\n" +
                "Người bạn đồng hành liền bảo: “Anh phải nói là chúng ta may mắn quá vì chúng ta nhặt được chiếc ví chứ!”\n" +
                "\n" +
                "Người kia liền giận dữ, quát tháo: “Tôi nhặt được trước thì chiếc ví là của tôi!”.\n" +
                "\n" +
                "Sau đó, phía xa xa có một đám người cầm gậy gộc, hô hoán “Ăn cắp, đứng lại!” tiến dần dần về phía 2 người khách bộ hành này. Thấy thế, người nhặt ví hoảng sợ và nói “Chúng ta sẽ chết chắc nếu họ tìm thấy chiếc ví trong người chúng ta!”\n" +
                "\n" +
                "Lúc này, người bạn đồng hành liền bảo: “Ồ không đâu! Hồi nãy anh không chịu nói là ‘Chúng ta’ cơ mà. Vậy nên anh hãy tự mình giải quyết chuyện cái ví với đám người kia đi!”.\n" +
                "\n" +
                "Bài học:\n" +
                "\n" +
                "Dân gian vốn có câu “Có họa cùng hưởng, có phúc cùng chia”. Tuy nhiên, bạn không nên vì lợi ích cá nhân mà dành phần may mắn về mình mà gạt bỏ người đã giúp đỡ mình. Vì đến lúc bạn gặp họa sẽ chẳng ai bên cạnh giúp đỡ bạn đâu! Mọi tai họa sẽ đổ ập lên đầu bạn nếu bạn chỉ chăm chăm dành phần hơn về phía mình ngay từ đầu mà gạt bỏ đồng đội.',2,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Thầy tu rởm','Chuyện kể, ngày xưa có một con sói rừng hung ác núp trong rừng sâu, lấy thú vui ăn thịt con nít làm bữa ngon cho mình. Hôm ấy, sói nghe tin, trong làng có một gia đình nghèo, hai vợ chồng đang lo lắng cho đứa con nhỏ lâm bệnh nặng của mình. Thấy thế, sói bèn nghĩ cách tiếp cận.\n" +
                "\n" +
                "Sói ta giả bộ làm thấy tu, khoác áo thánh, đi dép thánh, đầu đội mũ thánh hồng, trên tay cầm quyển kinh và miệng thì tụng kinh không ngớt. Sói cứ thế tiến vào làng với bộ dạng của một thầy tu, khiến cho nhiều người xúm lại. Thấy vậy, cha mẹ đứa trẻ bệnh nặng đó cũng chạy ra và mời thầy tu về chữa bệnh cho con mình.\n" +
                "\n" +
                "Sói ta giả vờ nói với cha mẹ đứa bé đó rằng: “Hãy chuẩn bị đồ ăn ngon để ta thết đãi thần linh và cầu nguyện cho đứa bé mau hết bệnh!”. Nghe vậy, vợ chồng nghèo lo xuống bếp chuẩn bị thức ăn. Khi mang dĩa đồ ăn lên thì chẳng thấy thầy tu và đứa con nhỏ của mình đâu cả. Chỉ sót lại vài mẩu xương và ít máu trên giường.\n" +
                "\n" +
                "Lúc này, cặp vợ chồng nghèo bật khóc thảm thiết khiến dân làng vào hỏi thăm. Sau khi nghe kể tường tận, dân làng biết mình đã bị lừa và quyết định mời thỏ về giúp trả thù. Thỏ được mời đến và nghe câu chuyện thảm thiết của vợ chồng nọ thì hiểu ra vấn đề bèn lên kế hoạch chơi khăm sói ta một vố.\n" +
                "\n" +
                "Thỏ trong diện mạo của thầy tu, mặc áo thánh và đi dép thánh, đầu đội mũ thánh, tay cầm quyển kinh và miệng thì lầm bầm đọc kinh. Thỏ gõ cửa nhà sói trong tận rừng sâu. Nghe thấy tu gõ cửa, sói vui mừng khôn xiết, bèn mời thầy vào nhà để nhờ thầy làm phé giải hạn.\n" +
                "\n" +
                "Thỏ nói rằng “Sói mau đi chuẩn bị đồ ăn để thầy thết đãi thần linh!”. Sói răm rắp nghe theo, liền ba chân bốn cẳng tiến vào bếp. Thỏ liền đi theo từ phía sau, canh lúc sói mở nầu nước sôi ra, thỏ liền xô sói vào nồi và luộc chín. Cuối cùng, sói đã đi đời nhà ma vì mắc lại chính mưu kế của mình bởi một người khác.\n" +
                "\n" +
                "Bài học:\n" +
                "\n" +
                "Câu chuyện là đòn cảnh tỉnh cho những ai tin vào vẻ ngoài của một con người. Câu chuyện cũng đã chỉ ra rằng, đánh giá nhân phẩm và năng lực của một người thông qua dáng vẻ bên ngoài sẽ không bao giờ đúng. Đôi khi, chính sự cả tin của mình sẽ khiến người bị tổn thương và mất mát lại là bản thân và những người xung quanh mình.',3,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Con muỗi và con bò đực','Tiếp theo, BIG.vn sẽ đưa bạn đến với một câu chuyện khác về con muỗi và con bò đực. Chuyện kể rằng, con muỗi bay xung quanh một bãi cỏ và quyết định nghỉ ngơi trên chính sừng của một con bò đực. Sau khi nghỉ ngơi, nó quyết định rời đi.\n" +
                "\n" +
                "Trước khi đi, muỗi ta cầu xin sự tha thứ của bỏ đực vì đã dùng sừng của bò để làm nơi nghỉ ngơi. Đơn giản là vì muỗi nghỉ bò đực hẳn rất giận khi nó ngủ trên sừng bò mà không có sự cho phép của bò. Tuy vậy, bò đực đã bình thản trả lời: “Không sao! Tôi thậm chí còn không biết anh đã ở đó!”.\n" +
                "\n" +
                "Bài học:\n" +
                "\n" +
                "Chúng ta thường tỏ ra mình quan trọng trong mắt người khác. Tuy nhiên, thực tế là, những điều ích kỷ mà bạn nói và làm, chỉ khiến bạn trông như một thằng hề. Giống như con muỗi, tỏ ra lịch sự chỉ nhằm thể hiện sự tồn tại của mình thôi. Giống với việc, bạn cho rằng mình là linh hồn của buổi tiệc. Nhưng điều này là không thể nào. Do đó, chỉ cần bạn là chính mình thì sẽ không trở thành con muỗi.',4,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Kiến và châu chấu','Vì sao ông cha ta luôn khuyến khích con người phải chăm chỉ, phải biết nhìn xa trông rộng, biết chuẩn bị cho những tình huống xấu nhất xảy ra để không hoang mang hay điêu đứng khi đối mặt? Bạn sẽ có được câu trả lời ngay khi đọc bài viết trong top 10 truyện ngụ ngôn hay và ý nghĩa do BIG.vn tổng hợp này!\n" +
                "\n" +
                "Một đàn kiến đang làm việc chăm chỉ suốt mùa hè để tích trữ lương thực cho mùa đông lạnh lẽo. Trong khi đó, một con châu chấu lại tranh thủ múa hát và vui chơi suốt mùa hè. Châu chấu ta cho rằng, đàn kiến thật không biết hưởng thụ khi mãi chăm chăm làm việc quần quật như thế.\n" +
                "\n" +
                "Thế rồi, khi mùa đông đến, trong khi đàn kiến ủ ấm và no đủ trong cái giá buốt của mùa đông thì châu chấu lại đói lả và cảm thấy lạnh lẽo. Ngay lúc đó, đàn kiến đã cứu đói và cưu mang châu chấu suốt mùa đông. Lúc này, châu chấu mới hiểu được vì sao kiến lại chăm chỉ làm việc suốt mùa hè như vậy. Tất cả là để chuẩn bị cho một mùa đông rét buốt và khan hiếm thực phẩm đang đến rất gần.\n" +
                "\n" +
                "Bài học:\n" +
                "\n" +
                "Chúng ta sống ở đời, không chỉ sống ngày 1 ngày 2 là xong. Vì thế, để tồn tại và sống một cuộc sống thoải mái nhất, hầu như ai cũng phải học cách nhìn xa trông rộng. Phải học cách nhận biết, điều gì sẽ xảy ra tiếp theo, để chuẩn bị ngay từ bây giờ, để khỏi bở ngỡ khi tiếp cận. Hãy lấy đàn kiến chăm chỉ trong câu chuyện trên để làm ví dụ cho sự chăm chỉ nhé!',5,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Con quạ và cái bình nước','Dân gian ta thường có câu “Có công mài sắt, có ngày nên kim”. Vậy bạn hiểu gì về câu nói này? Điều này sẽ bật mí ngay trong mẩu chuyện dưới đây của top 10 truyện ngụ ngôn hay và ý nghĩa do BIG.vn tổng hợp này.\n" +
                "\n" +
                "Ngày hè oi bức và nóng như lửa, con quạ khát khô cả cổ đang vội bay đi tìm nước uống. Và rồi, quạ ta phát hiện một bình nước có mực nước lưng chừng. Điều này gây khó khăn cho quạ khi cố gắng đặt mỏ vào bình để uống, vì nó không thể nào với được nước uống bên trong bình.\n" +
                "\n" +
                "Sau khi đã cố với cổ mà vẫn không thấy tốt hơn, quạ ta đã nảy ra ý tưởng: thả những viên sỏi nhỏ vào trong bình, đến khi mực nước dâng lên đến nơi mà nó có thể với tới tới được.\n" +
                "\n" +
                "Bài học\n" +
                "\n" +
                "Sự kiên trì chính là chìa khóa để bạn chinh phục cánh cửa thành công. Do đó, dù bạn đang ở trong tình hình nguy cấp và nghiêm trọng đến mức nào đi nữa, thì hãy kiên trì tìm cách giải quyết vấn đề đến cùng nhé! Như Wayne Gretzky đã từng nói “Bạn bỏ lỡ 100% cơ hội nếu bạn không tự cho mình cơ hội!”.',6,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cua mẹ và cua con','Một con cua nhỏ đang tập đi. Nó rất muốn đi về phía trước. Song, nó chỉ có thể đi ngang qua ngang lại mà không thể đặt chân mình phía trước như mọi người. Thấy vậy, cua mẹ liền làm mẫu cho con, cố gắng đi về phía trước nhưng cũng chỉ có thể đi ngang. Lúc này, cua mẹ cảm thấy xấu hổ vô cùng và liền xin lỗi cua con.\n" +
                "\n" +
                "10 truyện ngụ ngôn hay và ý nghĩa do BIG.vn tổng hợp\n" +
                "Bài học\n" +
                "\n" +
                "Trong cuộc sống, có rất nhiều điều không thể thực hiện được. Bởi ai cũng có thế mạnh của mình và có đủ tố chất để phát huy nó. Không cần phải gượng ép mình giống như người khác, làm được điều mà vốn dĩ nó là sở trường của người khác. Vì vậy, hãy biết đâu là giới hạn của mình, đừng phí sức để chạy theo những gì mình không thể chạm tới.',7,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Gã keo kiệt','Bạn có phải là người biết cách sử dụng đồ vật một cách hợp lý? Bạn sẽ học được giá trị sử dụng của mỗi món đồ thông qua câu chuyện sau đây.\n" +
                "\n" +
                "Một gã keo kiệt chôn vàng ở một nơi bí mật trong vườn nhà. Ngày ngày, gã ra đó đào vàng lên rồi đếm từng thỏi vàng một để kiểm tra có thất thoát chút nào không. Tuy nhiên, gã không hay biết rằng, chính hành động của gã đã khiến cho một tên trộm sinh nghi và theo dõi. Một đêm nọ, tên trộm chờ gã keo kiệt ngủ say và trộm hết số vàng ấy đi.\n" +
                "\n" +
                "Hôm sau, gã keo kiệt không tìm thấy số vàng của gã đâu, gã đau đớn và thét lên từng tiếng đầy kinh hãi. Tiếng thét của gã khiến cho một người lạ mặt để ý và hỏi thăm: “Sao ông lại chôn vàng trong cái lỗ ấy? Sao ông không cất vàng trong nhà để mỗi khi cần thì lấy bán đi mua đồ có dễ dàng hơn không?”\n" +
                "\n" +
                "Nghe vậy, gã keo kiệt liền phản bác: “Mua đồ ư? Tôi đâu bao giờ đụng đến vàng. Tôi không bao giờ dám nghĩ đến chuyện bán đi tí vàng nào cả!”.\n" +
                "\n" +
                "Nghe đến đây, người lạ mặt nhặt một hòn đá và ném xuống lỗ đó. Ông ta nói: “Nếu thế thì, ông lấp lỗ đó lại đi. Vì hòn đá này cũng đáng giá bằng đống vàng của ông mà thôi!”.\n" +
                "\n" +
                "Bài học: Một vật mà không dùng được thì cũng chả có giá trị gì. Vậy thì, dù cho món đồ đó có đắt giá hay đẹp lóng lánh như vàng thì cũng chẳng giữ để làm gì.',8,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Cáo cụt đuôi','Một con cáo bị mắc bẫy, sau nhiều lần giật mạnh đau đớn vũng vẫy mới thoát được. Dù chạy nhanh được ra khỏi chỗ nguy hiểm đó, cáo ta vẫn tiếc rẻ chiếc đuôi đẹp đẽ của mình đã bị kẹt lại trong bẫy.\n" +
                "\n" +
                "Một thời gian dài, cáo ta không dám gặp mặt những con cáo khác vì nó biết rằng, tất cả lũ cáo kia sẽ lấy nó làm trò cười. Tuy nhiên, nó không muốn sống một mình đơn độc thế này. Thế là, cáo ta quyết định tổ chức một cuộc họp mặt để thông báo vài điều quan trọng.\n" +
                "\n" +
                "Sau khi chờ cho bạn bè cáo đến đông đủ, cáo cụt đuôi đứng dậy và diễn thuyết về tình trạng săn bắt cáo hiện nay. Nó nói rằng, bây giờ con người đi săn cáo là để lấy đuôi cáo, họ cắt đuôi cáo để làm chiến tích săn thú. Vì thế, cáo ta khuyên những con cáo dưới kia, để bảo đảm tính mạng cho mình, hãy tự cắt đuôi của mình.\n" +
                "\n" +
                "Khi cáo ta nói xong, một cụ cáo đứng dậy, nói và cười mỉm: “Lão cáo, xin lão quay đi chỗ khác một chút, chúng tôi cần thảo luận rồi sẽ trả lời lão sau!”.\n" +
                "\n" +
                "Khi con cáo cụt đuôi tội nghiệp quay mặt đi, cả làng cáo ồ lên cười và la ó. Lúc này, cáo cụt đuôi biết rằng có thuyết phục lũ cáo kia bỏ đuôi của chúng thì cũng chẳng có ích gì.\n" +
                "\n" +
                "Bài học: Đừng bao giờ nghe lời những người không muốn bạn hơn họ. Đây là một trong những thủ thuật nhìn người và đối nhân xử thế mà người xưa muốn truyền lại. Bởi những người luôn tự ti về khiếm khuyết của mình sẽ nghĩ ra cách để người khác phải giống mình. Do đó, hãy biết cách chọn bạn mà chơi, chọn người tốt để tiếp xúc, để học hỏi cái hay và phát triển bản thân.',9,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Hổ và Ngựa','Con ngựa có tính huênh hoang, khoác lác, ra khỏi nhà là nó nện bốn cái vó xuống đất, nghe ròn hơn gõ mõ làng, hí váng cả tai hàng xóm. Một hôm trời chưa sáng hẳn, ngựa còn đang ngủ say, chủ nhà đã ra bắt ngựa cưỡi đi chợ.\n" +
                "Ngựa phải đưa chủ qua suối, qua đồi, qua khe. Đường xa, bụng đói, chân mỏi, người đẫm mồ hôi, nhưng con ngựa không dám kêu, vì kêu thì sợ lúc trở về chủ sẽ không cho ăn bắp ngô, chậu cám. Đến chợ, chủ nhà buộc ngựa ngoài gốc cây, vào quán ăn thịt uống rượu. Con ngựa khát nước khô cả cổ mà không dám đòi, vì sợ chủ ăn không ngon, lúc về sẽ bắt ngựa chạy nhanh hơn. Ngựa về, bụng đã đói, chân đã mỏi, nhưng chủ nhà vẫn giục ngựa chạy nhanh. Lưng ngựa oằn xuống, bọt xùi ra mép, ngựa vẫn cắm đầu chạy một mạch, mong mau về đến nhà kiếm nắm cỏ tươi. Nhưng vừa mới về đến cửa thì con chủ nhà đã ra đón. Ngựa lại phải đưa con chủ nhà đi thăm nương, rẫy. Mãi đến nửa chiều, ngựa mới được về nhà uống một chậu nước cám. Uống xong, lại sức, con ngựa ra sông tắm. Vừa mới tắm xong ngựa đã lên bờ giũ lông, hí vang, ra dáng khoan khoái lắm. Lúc đó có một con hổ đi ngang. Thấy hổ lủi thủi đi một mình, đuôi cụp, đầu cúi, dáng buồn bã, ngựa nghển cổ lên nói khích:\n" +
                "- Đi đâu mà trông khổ sở thế anh hổ?\n" +
                "- Tôi đi kiếm ăn ở rừng dưới về. Anh chẳng làm gì sao mà trông thong thả thế?\n" +
                "Ngựa càng lên mặt, giũ lại bộ lông một lần nữa, hí vang thêm một lượt, rồi mới ngạo nghễ nói:\n" +
                "- Tôi lúc nào mà chẳng thong thả? Đi dạo chơi từ sáng đến giờ, bây giờ ra tắm cái cho khỏe.\n" +
                "- Anh sung sướng quá! Phận tôi thì phải chạy tối ngày mà có khi cũng chẳng được miếng ăn.\n" +
                "Được hổ nịnh, ngựa càng vênh mặt:\n" +
                "- Anh vất vả quá thật. Đường rộng rãi thế này, mà tôi dạo một lúc đã thấy mỏi chân. Còn anh thì núi rừng thế kia, đi vướng trước, đụng sau làm sao mà chịu được?\n" +
                "Ngựa còn khoe lúc nào cũng thừa thóc thừa ngô, ăn chẳng hết, rồi mời hổ về nhà chơi, để xem những thứ đó. Tính hổ ít nói, lại không muốn mang ơn bạn trước, nên mời ngựa đến nhà mình chơi trước, rồi mới đến trả lễ sau. Hổ về, chạy vào rừng tìm bắt những con nai, con hươu làm tiệc đón ngựa. Ngựa đến cùng hổ ăn thịt, uống rượu tới một ngày rồi kết nghĩa làm anh em. Xong bữa tiệc đó, ngựa về lo đón hổ, tỏ cho hổ biết mình là người sang trọng. Ngựa lấy lục lạc tròng vào cổ, mang yên vào lưng, ngắm nghía một lúc rồi ra đứng đón hổ. Hôm đó nhà chủ ngựa lại có cỗ, ngựa chờ chủ nhà ngủ yên, vào lấy hết mâm cỗ ra tiếp hổ. Hai bên ngồi ăn uống, ngựa chỉ vào từng món thức ăn, khoe:\n" +
                "- Cái này là thịt gà xào này!\n" +
                "- Cái này là mật ong này, ngọt lắm.\n" +
                "- Cái này làm chỗ ở của tôi - Ngựa chỉ ra chuồng, nói tiếp - chỗ tôi ở mưa không dột, nắng không đến, chứ đâu có khổ sở như anh, lúc mưa phải núp vào hang đá, lúc nắng trú dưới bóng cây...\n" +
                "Ngựa còn đang khoác lác thì trời đã sáng, chủ nhà cầm một cái roi ra bắt ngựa cưỡi đi chợ. Thấy ngựa ăn cắp mâm cỗ, sẵn roi chủ nhà đến tóm bờm ngựa đánh một trận nên thân. Ngựa cúi đầu chạy, hổ núp bên ngoài nhìn thấy mọi chuyện vừa xảy ra. Hổ tự hỏi:\n" +
                "- Ta ở trong rừng. Núp mưa trong hang đá, núp nắng dưới gốc cây mà không bị đánh là sướng, hay ở nhà gỗ ăn cám ngô mà bị đánh là sướng?\n" +
                "- Đi đường dốc, vấp phải đá, quàng phải dây mà không bị người ta ngồi trên lưng là sướng, hay đi đất bằng, đường rộng mà bị người ngồi trên lưng là sướng?\n" +
                "Hổ ra bờ suối, chui vào bụi rậm nằm, chờ ngựa, còn ngựa đưa chủ đi đến nửa buổi chiều mới được về. Ăn xong một nắm cỏ, nó lại ra suối tắm. Hổ hỏi:\n" +
                "- Anh ngựa này? Cái sướng của anh tôi không muốn đâu! Anh được ăn ngô, ăn thóc, ăn cỏ, được ở nhà gỗ mà bị người ta đánh vào đầu, người ta cưỡi lên lưng thì sướng làm sao được?\n" +
                "Con ngựa chống chế:\n" +
                "- Tôi không phải làm nhà mà được ở, ngô, thóc tôi không cấy mà được ăn... Anh bảo thế chưa sướng thì thế nào là sướng? Lủi thủi trong rừng quanh năm suốt đời như anh là sướng đấy sao?\n" +
                "- Núi rừng tuy có âm u rậm rạp, nhưng tôi muốn đi đâu cũng được, muốn nằm đâu cũng được. Lúc tôi ngủ không ai dám gọi, lúc tôi chơi không ai dám ngăn. Hươu, nai, cáo, cầy không phải là của tôi, nhưng tôi có công bắt được thì tôi cứ ăn; không bị ai giành lại, không bị ai đánh mắng. Cái sướng của anh tôi không muốn đâu... Tôi không làm bạn với anh nữa đâu. Tôi đi về rừng rậm núi cao của tôi đây.\n" +
                "Nói rồi hổ cong đuôi chạy vào rừng.',10,10)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Đại bàng và con chim sẻ','Ở khu rừng nọ có một con đại bàng huênh hoang hợm hĩnh. Gặp bất cứ con chim nào, đại bàng cũng khoe khoang rằng nó là chúa tể của các loài chim, rằng nó khỏe nhất, kêu to nhất, bay cao nhất.\n" +
                "Một hôm, đại bàng tập hợp tất cả các loài chim lại và lên giọng thách thức:\n" +
                "- Hỡi các loài chim, trong các người có kẻ nào dám đọ sức kêu to, ăn nhiều, bay cao cùng ta không nào?\n" +
                "Cả bầy chim sợ hãi nhìn nhau chẳng dám ho he một tiếng. Thấy thế đại bàng càng được thế:\n" +
                "- Ta bất chấp tất cả các ngươi đấy.\n" +
                "Lúc ấy, một chú sẻ con bèn lên tiếng:\n" +
                "- Bác đại bàng ơi, thi ăn nhiều, kêu to với bác thì chúng em chẳng dám rồi, nhưng thi bay cao với bác thì em cũng thử một lần xem sao.\n" +
                "Cả đại bàng lẫn các loài chim khác đều sửng sốt ngoảnh lại nhìn chim sẻ nhưng nó không hề nao núng.\n" +
                "Cuộc thi bắt đầu. Ðại bàng vỗ cánh bay lên. Khi đã bay cao hơn cả những ngọn cây cao nhất, đại bàng liền gọi:\n" +
                "- Ê, sẻ con chết rấp ở đâu rồi?\n" +
                "Lúc ấy sẻ bay lên đầu đại bàng, đáp:\n" +
                "- Em đây, bác cứ yên tâm, em không bỏ cuộc đâu. Ðại bàng cố sức bay cao lên nữa. Khi cao hơn cả những đỉnh núi mù sương, đại bàng lại cất tiếng gọi:\n" +
                "- Thế nào, sẻ con, vẫn theo ta được đấy chứ?\n" +
                "Chim sẻ lại bay lên trả lời:\n" +
                "- Vâng, em vẫn cố theo bác đây. Chừng bác mệt rồi sao mà bay chậm thế?\n" +
                "- Ðời nào!\n" +
                "Ðại bàng nói hổn hển rồi bay ngược lên cao cao mãi, lần này đại bàng đã ở trên cả những đám mây trắng xóa. Nó tin là sẻ con chẳng thể nào bay lên tầng cao này được. Ðôi cánh đã mỏi rã rời. Cổ và đầu nặng trĩu, đại bàng nói chẳng ra hơi.\n" +
                "- Sẻ con đã chịu thua ta rồi chứ?\n" +
                "- Chưa đâu, em vẫn ở trên đầu bác đây này - Giọng sẻ con vẫn lanh lảnh.\n" +
                "Ðại bàng quyết không chịu thua chim sẻ, nó lấy hết sức tàn rướn lên cao nhưng không được nữa. Ðại bàng tắt thở. Từ trên cao nó rơi thẳng xuống vực như một hòn đá vậy. Khi ấy, sẻ con chỉ việc xòe cánh ra từ từ hạ xuống giữa các loài chim đang nóng lòng chờ tin cuộc đọ sức. Chúng không hiểu sẻ con có mưu mẹo gì mà thắng được đại bàng vốn bay cao nhường ấy. Chỉ có mỗi một con sẻ con khác là trông thấy lúc cuộc thi bắt đầu, sẻ con đã đậu ngay trên lưng đại bàng. Thì ra đại bàng đã mất công chở chim sẻ trên lưng mà không biết. Mỗi lần đại bàng cất tiếng hỏi, sẻ con lại từ lưng đại bàng bay lên đáp lời, thành thử nó chẳng mất tí sức nào.\n" +
                "Bằng trí thông minh và lòng dũng cảm, sẻ con đã thắng đại bàng kiêu ngạo và to lớn hơn nó gấp nghìn lần.',11,10)");

        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Những ngón tay','Một hôm, những ngón tay tranh luận với nhau xem những ngón nào là quan trọng hơn cả. Thoạt tiên, ngón tay giữa nói:\n" +
                "- Tôi chiếm vị trí trung tâm của bàn tay, không có tôi thì bàn tay chẳng ra bàn tay nữa.\n" +
                "Các ngón khác đều cãi rằng:\n" +
                "- Tuy cậu ở vị trí trung tâm và cao hơn tất cả nhưng chỉ ngồi đó cho có vị thôi, chứ có giúp được việc gì cho bàn tay để cầm nắm đâu!\n" +
                "Ngón tay đeo nhẫn vênh mặt nói một cách tự hào rằng hắn đóng vai trò quan trọng nhất: chính hắn là người mang dấu hiệu tượng trưng cho sự trưởng thành của chủ, tức là đeo nhẫn cưới.\n" +
                "Nhưng các ngón tay khác đều cười và nhận xét rằng:\n" +
                "- Thà cậu im đi còn hơn. Chiếc nhẫn cưới ấy ông chủ cất trong túi nhiều hơn, cốt để các cô gái trẻ tưởng ông ấy chưa lập gia đình, chứ có đeo đâu. Ngoài ra cậu có làm được việc gì khác đâu?\n" +
                "- Quan trọng nhất vẫn là tôi! – Ngón tay trỏ nói – Ai là người chỉ đường? Ai là người vạch ra những thiếu sót của cơ quan? Chính là tôi. Thử nghe ông chủ thường nói: Các bạn, nguyên nhân sự chậm tiến của chúng ta chính là ở đây..., mọi người đều sợ tôi trỏ vì không ai muốn mình là nguyên nhân chậm tiến của cả tập thể.\n" +
                "- Bạn nhầm rồi, bạn thân mến ạ - Ngón tay cái phản đối – không phải chỉ mình bạn biết chỉ. Tôi cũng chỉ, nhưng chỉ một cách khéo léo, tế nhị hơn cơ. Tôi không chỉ thẳng vào người ta mà lại chỉ qua bên phải, qua sau lưng, nhưng vẫn trúng thủ phạm như thường. Hơn nữa, trong một số trường hợp, khi muốn thoái thác trách nhiệm, tôi giúp ông chủ chỉ cho khách sang cửa khác, gặp người khác mà cầu xin, phản đối...\n" +
                "Từ nãy chỉ có ngón tay út im lặng. Vả lại, nó còn biết khoe khoang gì nữa: nó vốn là ngón tay bé nhất. Nhưng...\n" +
                "- Kìa, tại sao chú út không nói gì? - Những ngón tay khác hỏi.\n" +
                "- Em cũng biết chỉ đấy chứ. Vì em vốn nhỏ bé cho nên trong những lúc ông chủ cần tự phê bình, ông ấy dùng em chỉ vào ngực mình thì chẳng ai trông thấy cả. Ngoài ra, em còn được việc trong những khi cần móc ngoặc: nếu thỏa thuận với ai, chỉ cần nói xong ngay. Thế là cả hai người đều chìa em ra móc với nhau. Nhiều khi được việc ra phết đấy!',1,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, ' Cuộc kiểm nghiệm','Có một anh Vẹt sau khi học được vài ba tiếng Người thì lấy làm hãnh diện và tự phụ lắm. Anh ta tuyên bố:\n" +
                "- Ta biết nói tiếng Người. Từ nay các người sẽ không bao giờ nghe ta nói một lời nào bằng tiếng chim nữa !\n" +
                "- Ồ, ồ ! - Mấy chị chim Chìa Vôi thốt lên – Thông minh làm sao ! Anh ta chỉ nói bằng tiếng Người ! Anh ta khinh rẻ tiếng chim !\n" +
                "- Anh ta biết nói tiếng Người ư? – Bác Quạ già hỏi – Thì đã sao ! Thế càng tốt ! Nhưng như thế không có nghĩa là anh ta thông minh hơn tất cả những kẻ khác. Tôi cũng biết nói tiếng Người nhưng chưa bao giờ tôi cho mình là một nhà thông thái.\n" +
                "- Thế thì bác nói đi, nói với anh ta bằng tiếng Người đi ! Mấy chị chim Chìa Vôi năn nỉ - Chúng em cam đoan là anh ta chẳng bao giờ nói với bác bằng tiếng chim đâu. Đấy, rồi bác sẽ thấy !\n" +
                "- Nào, để tôi thử xem ! – Bác Quạ nói rồi nhảy sang cành cây, nơi anh Vẹt đang ngồi với vẻ quan trọng.\n" +
                "- Chào anh Vẹt ! – Bác Quạ cất tiếng chào và tự giới thiệu bằng tiếng Người rất rành rẽ - Tôi là Quạ !\n" +
                "- Vẹt là thằng ngu ! Vẹt là thằng ngu ! – Anh Vẹt cũng đáp lại bằng tiếng Người rất trịnh trọng - Vẹt là thằng ngu !\n" +
                "- Bác nghe thấy chưa ? - Mấy chị Chìa Vôi thán phục reo lên – Anh ta đã làm cho bác tin rồi chứ ? Anh ta nói toàn bằng tiếng Người, bác tin rồi chứ ?\n" +
                "- Vâng, tôi tin ! Và tôi công nhận là anh ta nói rất đúng !',2,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chị Mèo nhận họ','Nghe người ta nói Hổ và Báo cũng thuộc họ nhà Mèo, chị Mèo hí hửng lắm:\n" +
                "- Ồ! Thế mà ta, một con ngu, đã không biết ta có họ hàng như vậy! Đã thế, từ rày biết tay ta...\n" +
                "Suy nghĩ một lúc, Mèo ta nhảy tót lên lưng bác Lừa.\n" +
                "- A! Chuyện gì thế này? - Bác Lừa ngạc nhiên.\n" +
                "- Chở ta đi đến chỗ ta ra lệnh! Chở đi và không nói năng lôi thôi! Mày có biết bà con họ hàng của ta là ai không? - Mèo ta thốt lên trong lúc vẫn ngồi chễm chệ trên u vai bác Lừa.\n" +
                "- Ai thế? - Bác Lừa tò mò.\n" +
                "- Ông Hổ và ông Báo chứ còn ai! Không tin à? Không tin thì cứ đi hỏi chị Quạ mà xem!\n" +
                "Bác Lừa đành phải cõng Mèo đi hỏi chị Quạ. Chị Quạ xác nhận:\n" +
                "- Đúng thế! Mèo, Hổ, Báo, Linh Miêu, thậm chí cả Sư Tử đều cùng họ nhà Mèo mà ra.\n" +
                "- Bây giờ thì tin rồi chứ? - Mèo ta thốt lên rồi đưa móng chân quào vào u vai bác Lừa - Chở ta đi!\n" +
                "- Đi đâu? - Bác Lừa hỏi giọng tỉnh bơ như không - Chở đến ông Hổ hay ông Báo?\n" +
                "- Khó... ô... ông! - Mèo ta nói, giọng run rẩy - Chở ta đến... đến lũ... lũ gì nhỉ? Lũ Chu... uột!\n" +
                "Và thế là bác Lừa chở Mèo ta đến chỗ có Chuột.\n" +
                "Bởi một lẽ, dù sao thì đó cũng chỉ là một con Mèo!',3,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Thần Gió và Mặt Trời','Sau khi gây ra thiên tai, bão táp làm đổ sập nhà cửa, cây cối, Thần Gió càng lúc càng tỏ ra ngạo mạn. Một hôm Thần Gió tranh cãi với Mặt Trời xem ai là kẻ mạnh nhất. Nhìn xuống mặt đất, thấy một khách bộ hành khoác chiếc áo tơi đang đi, Mặt Trời bảo: \"Chẳng cần cãi nhau làm gì, hễ ai làm cho người khách bộ hành kia phải cởi chiếc áo ra sẽ thắng cuộc và là kẻ mạnh nhất!\"\n" +
                "Thần Gió bắt đầu dương oai, thổi làm cát bụi bốc lên mù mịt, cây cối đổ rạp. Những cơn cuồng phong liên tiếp nổi lên, kèm với cái lạnh buốt da, buốt thịt. Tuy nhiên, gió càng lớn chừng nào thì người bộ hành càng cố giữ chặt chiếc áo tơi của mình, làm cho Thần Gió không cách nào lột được chiếc áo kia ra.\n" +
                "Đến phiên Mặt Trời, từ trong đám mây đen, Mặt Trời từ từ ló dạng. Những tia nắng vàng tỏa ra khắp nơi, làm người bộ hành cảm thấy ấm áp, thoải mái. Mặt Trời càng lúc càng nóng ấm. Thế rồi người bộ hành tự động cởi bỏ chiếc áo tơi vô dụng kia ra.',4,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Một kẻ hợm mình','Anh Gà Trống bay lên đậu trên hàng rào rồi rướn cao đầu lên trời.\n" +
                "- Anh đang ngắm bầu trời đấy à? - Chị Vịt thấy thế liền hỏi.\n" +
                "- Bầu trời là cái gì đối với tôi cơ chứ ! – Gà Trống đáp lại và rướn cao đầu hơn - Một khoảng không gian ngu xuẩn chất đầy hành tinh đến nỗi không còn chen vào đâu được. Một sự luân phiên nhàm chán giữa ngày và đêm. Tất cả những cái đó đã quá quen thuộc.\n" +
                "- Thế mà từ lâu em không biết anh là một người thú vị đến thế ! Anh có những ý tưởng mới cao siêu làm sao! Chị Vịt thốt lên.\n" +
                "- Tôi dang đôi cánh của mình – Anh Gà Trống tiếp tục nói – Tôi sẽ bay cao hơn cả bầu trời, sẽ thách thức với tất cả các hành tinh và rồi bí ẩn nhưng kiêu hãnh, tôi sẽ quay trở về với biển xanh khôn cùng và ... tôi sẽ chìm.\n" +
                "Nói đến đây, Gà Trống chóng mặt mất thăng bằng, ngã nhào xuống vũng nước.\n" +
                "- Ôi ! - Chị Vịt sợ hãi – Anh đang chìm đấy ư?\n" +
                "- Ừ ! Đang chìm ! – Gà Trống tức giận trả lời, và rồi nhìn thấy một chú giun, anh ta liền mổ, nuốt chửng.\n" +
                "Hệt như tất cả những anh gà khác !',5,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Lừa và Hải Cẩu','Một cái cây đẹp mọc ngay giữa đồng.\n" +
                "Bác Lừa ta chạy băng đồng, mải nhìn ngang nhìn ngửa nên đâm bổ vào, nẩy đom đóm mắt.\n" +
                "Lừa giận lắm, bác ta đến bờ sông, gọi Hải Cẩu:\n" +
                "- Hải Cẩu ơi ! Anh có biết giữa cánh đồng có một cái cây mọc không?\n" +
                "- Sao lại không biết!\n" +
                "- Thế thì anh đi hạ cái cây ấy đi ! Răng anh sắc lắm mà...\n" +
                "- Để làm gì?\n" +
                "- Tôi vừa va phải nó, sưng hết cả mặt mũi lên đây này! Khốn khổ làm sao!\n" +
                "- Anh nhìn đi đâu?\n" +
                "- Nhìn đâu... nhìn đâu... Tôi mới mải nhìn có một tý mà ra nông nỗi này đây... Đi mà hạ cái cây đi cho rồi!\n" +
                "- Hạ đi thì tiếc lắm. Nó làm đẹp cho cả cánh đồng.\n" +
                "- Nhưng nó cản trở việc đi lại của tôi. Hạ nó đi anh !\n" +
                "- Tôi không muốn.\n" +
                "- Khó nhọc lắm sao?\n" +
                "- Không khó nhọc nhưng tôi sẽ không hạ.\n" +
                "- Tại sao?\n" +
                "- Tại vì nếu tôi hạ cái cây ấy xuống thì anh sẽ lại va vào gốc.\n" +
                "- Thế thì anh hãy đào cả gốc nó đi !\n" +
                "- Tôi mà đào cả gốc thì anh lại rơi xuống hố, què chân.\n" +
                "- Tại sao?\n" +
                "- Tại vì anh là con Lừa !',6,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Vẻ đẹp','Gấu và Sói ngồi nói chuyện trên trời dưới đất.\n" +
                "Cạnh đó có một chị Bướm đang bay lượn. Chị bay từ cây này sang cây khác.\n" +
                "Nhìn thấy chị Bướm, bác Gấu đưa mắt ngắm nghía.\n" +
                "- Xem kìa! - Bác nói với anh Sói - Tuyệt diệu làm sao!\n" +
                "- Ở đâu? - Sói hỏi.\n" +
                "- Đấy kìa, trên cành cây, ngay trên đầu anh đấy! Một chị Bướm! Biết bao nhiêu vẻ đẹp trên thân hình chị!...\n" +
                "- Trên thân hình chị Bướm ấy à? - Sói cười mỉa.\n" +
                "- Anh không thích chị Bướm ấy ư? - Bác Gấu ngạc nhiên.\n" +
                "- Có cái gì hay ho trong con bướm ấy nào?\n" +
                "- Khỏi nói! - Bác Gấu cãi lại - Anh xem kìa! Chị ấy bay lượn mới nhẹ nhàng uyển chuyển làm sao! Những nét hoa trên đôi cánh đẹp đẽ làm sao! Thật là tuyệt vời!\n" +
                "- Uyển chuyển ư? Nét hoa ư? Tôi chẳng thấy một cái gì gọi là hay ho cả!\n" +
                "- Nhưng...\n" +
                "- Không có \"nhưng\" gì cả! Cách đây không lâu, tôi nhìn thấy một con Cừu non mũm mĩm. Chà, toàn là thịt! - Sói nói, hai mắt sáng rực lên - Đấy mới thật là đẹp!\n" +
                "- A! - Bác Gấu nói, vẻ chán chường - Thiết tưởng tôi đã hiểu anh...',7,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Các cậu bé và người hàng thịt','Hai cậu bé vào cửa hàng mua thịt. Trong khi người bán thịt còn đang lăng xăng, một cậu vớ lấy miếng thịt bỏ vào ngực cậu kia. Người hàng thịt quay lại thấy mất miếng thịt và qui cho họ đã đánh cắp. Nhưng cậu bé đã lấy miếng thịt liền thề có chư thần chứng giám là cậu không hề có miếng thịt trong người. Còn cậu giấu miếng thịt cũng thề có chư thần chứng giám là chính cậu không hề lấy miếng thịt. Người hàng thịt đoán ra mưu kế của họ và lên tiếng: \"Nay các cậu thoát khỏi tay ta bằng những lời thề giả dối nhưng đừng hòng thoát khỏi tay chư thần.\n" +
                "Truyện ngụ ngôn này chứng tỏ rằng một lời thề giả dối bao giờ cũng bất chính dù có che đậy nó thế nào đi chăng nữa.',8,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Hai con gà trống','ó hai con gà cùng một gà mẹ sinh ra và nuôi dưỡng. Khi lớn lên, đủ lông đủ cánh trở thành hai con gà trống, chúng lại hay cãi vã nhau. Con nào cũng tự cho mình đẹp đẽ, oai phong hơn, có quyền làm Vua của Nông Trại.\n" +
                "Một hôm sau khi cãi nhau, chúng đánh nhau kịch liệt, định rằng hễ con nào thắng sẽ được làm Vua của Nông Trại. Sau cùng, dĩ nhiên một con thắng và một con bại.\n" +
                "Con gà thắng trận vội nhảy lên hàng rào, vỗ cánh và cất tiếng gáy vang, ca tụng sự chiến thắng của mình. Chẳng ngờ tiếng gáy của con gà làm một con chim ưng khi bay ngang qua đấy chú ý đến. Thế là, con chim ưng xà xuống bắt con gà thắng trận mang đi mất. Trong khi đó con gà bại trận vẫn còn nằm thoi thóp thở.\n" +
                "\n" +
                "o O o\n" +
                "\n" +
                "Lời bàn: Câu chuyện muốn khuyên chúng ta phải thương yêu, và đùm bọc anh chị em trong nhà để người ngoài không hiếp đáp được.\n" +
                "Ca dao:\n" +
                "Khôn ngoan đối đáp người ngoài\n" +
                "Gà cùng một mẹ chớ hoài đá nhau',9,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Mưu trí Hồ Ly','Cọp rừng là loài quái ác, đi đến đâu muôn thú đều sợ. Một con Cọp rừng bắt được con Hồ Ly. Hồ Ly tinh khôn liền doạ:\n" +
                "- Nè, anh không được đụng đến tôi, Thượng đế cử tôi xuống khu rừng này để thống soái muôn loài. Anh chạm đến chân lông tôi là phạm thượng đấy! Nếu không tin lời tôi thì hai ta có thể làm thử nghiệm xem muôn thú sợ cái uy của tôi hay cái uy của anh thì biết. Chúng ra sẽ đi một vòng trong khu rừng, tôi đi trước, anh theo sau bảo vệ tôi thì anh sẽ rõ.\n" +
                "Cọp nghe Hồ Ly nói có lý, thử một phen coi nó nói thiệt hay láo. Thế là Hồ Ly đi trước, Cọp theo sau vào rừng, đi đến đâu muôn thú hoảng sợ bỏ chạy ráo!\n" +
                "Muôn thú bỏ trốn, Cọp vẫn không biết rằng vì chúng sợ mình, lại cứ nghĩ chúng sợ Hồ Ly mà chạy. Vậy là Hồ Ly thoát chết.\n" +
                "\n',10,11)");
        db.QuerryData("INSERT INTO TruyenMod VALUES(null, 'Chim tu hú và hai nhà vua','Khi chim ưng làm vua rất thích nghe bầy chim thổi sáo. Ngày hội nhạc, chim ưng cho môt ngàn con chim cùng thổi sáo chung một lúc. Trog một ngàn con chim đó có Tu hú là không biết thổi, nhưng cũng cứ dự phần vào để kiếm miếng ăn vua cho. Khi chim ưng thôi giữ chức, chim Phượng hoàng được lên thay. Vua mới này cũng rất thích nghe thổi sáo, nhưng lại chỉ muốn nghe tiếng thổi của từng cây sáo một. Tu hú biết mình sắp bị lộ liền xin ra khỏi ban nhạc. Chim Hạc là nhạc trưởng thấy thế hỏi:\n" +
                "- Vì sao đang làm ăn khá thế mà xin nghỉ?\n" +
                "Tu hú đáp:\n" +
                "- Làm ăn chung thì dựa dẫm nhau được chứ làm ăn riêng thì biết dựa vào ai?',11,11)");








    }
}
