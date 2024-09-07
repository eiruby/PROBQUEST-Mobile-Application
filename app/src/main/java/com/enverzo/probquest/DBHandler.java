package com.enverzo.probquest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.enverzo.probquest.ui.profile.ProfileModelClass;
import com.enverzo.probquest.ui.study.StudyModelClass;
import com.enverzo.probquest.ui.tests.T2TestResultModelClass;
import com.enverzo.probquest.ui.tests.TestResultModelClass;
import com.enverzo.probquest.ui.tests.TestsModelClass;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class DBHandler extends SQLiteOpenHelper {
    Context context;
    private static final String DB_NAME = "probquestdb.db";
    private static final int DB_VERSION = 2;

    // Test Score Table
    private static final String TABLE1_NAME = "TestsScores";
    private static final String TEST_CODE = "test_code";
    public static final String SCORE = "score";
    public static final String TIME = "time";
    private static final String testsTable =
            "CREATE TABLE " + TABLE1_NAME + "("
                    + TEST_CODE + " INTEGER PRIMARY KEY, "
                    + SCORE + " INTEGER, "
                    + TIME + " INTEGER)";

    // Profile Table
    private static final String TABLE2_NAME = "UserProfile";
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] byteImage;
    private static final String profileTable =
            "Create table " + TABLE2_NAME + "(profileId INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",fname TEXT " +
                    ",lname TEXT " +
                    ",section TEXT " +
                    ",image BLOB)";

    //Topics TIme Table
    private static final String TABLE3_NAME = "StudyTime";
    private static final String TOPICS_ID = "topicsId";
    public static final String TIME_IN_SEC = "timeInSec";
    private static final String studyTimeTable =
            "CREATE TABLE " + TABLE3_NAME + "("
                    + TOPICS_ID + " INTEGER PRIMARY KEY, "
                    + TIME_IN_SEC + " INTEGER)";

    //Topic One Pre-Test Table
    public static final String TABLE4_NAME = "T1PreTestResult";
    private static final String t1PreTestResultTable = "CREATE TABLE " + TABLE4_NAME + "(t11Id INTEGER PRIMARY KEY AUTOINCREMENT, t11questions TEXT, t11btn1 TEXT, t11btn2 TEXT, t11btn3 TEXT, t11btn4 TEXT, t11solution TEXT, t11answer TEXT, t11mark INTEGER, t11btnbg1 INTEGER, t11btnbg2 INTEGER, t11btnbg3 INTEGER, t11btnbg4 INTEGER)";

    //Topic One Post-Test Table
    public static final String TABLE5_NAME = "T1PostTestResult";
    private static final String t1PostTestResultTable = "CREATE TABLE " + TABLE5_NAME + "(t12Id INTEGER PRIMARY KEY AUTOINCREMENT, t12questions TEXT, t12btn1 TEXT, t12btn2 TEXT, t12btn3 TEXT, t12btn4 TEXT, t12solution TEXT, t12answer TEXT, t12mark INTEGER, t12btnbg1 INTEGER, t12btnbg2 INTEGER, t12btnbg3 INTEGER, t12btnbg4 INTEGER)";

    //Topic Two Pre-Test Table
    public static final String TABLE6_NAME = "T2PreTestResult";
    private static final String t2PreTestResultTable = "CREATE TABLE " + TABLE6_NAME + "(t21Id INTEGER PRIMARY KEY AUTOINCREMENT, t21questions TEXT, t21mark INTEGER, t21btnbg1 INTEGER, t21btnbg2 INTEGER)";

    //Topic Two Post-Test Table
    public static final String TABLE7_NAME = "T2PostTestResult";
    private static final String t2PostTestResultTable = "CREATE TABLE " + TABLE7_NAME + "(t22Id INTEGER PRIMARY KEY AUTOINCREMENT, t22questions TEXT, t22mark INTEGER, t22btnbg1 INTEGER, t22btnbg2 INTEGER)";

    //Topic Three Pre-Test Table
    public static final String TABLE8_NAME = "T3PreTestResult";
    private static final String t3PreTestResultTable = "CREATE TABLE " + TABLE8_NAME + "(t31Id INTEGER PRIMARY KEY AUTOINCREMENT, t31questions TEXT, t31btn1 TEXT, t31btn2 TEXT, t31btn3 TEXT, t31btn4 TEXT, t31solution TEXT, t31answer TEXT, t31mark INTEGER, t31btnbg1 INTEGER, t31btnbg2 INTEGER, t31btnbg3 INTEGER, t31btnbg4 INTEGER)";

    //Topic Three Post-Test Table
    public static final String TABLE9_NAME = "T3PostTestResult";
    private static final String t3PostTestResultTable = "CREATE TABLE " + TABLE9_NAME + "(t32Id INTEGER PRIMARY KEY AUTOINCREMENT, t32questions TEXT, t32btn1 TEXT, t32btn2 TEXT, t32btn3 TEXT, t32btn4 TEXT, t32solution TEXT, t32answer TEXT, t32mark INTEGER, t32btnbg1 INTEGER, t32btnbg2 INTEGER, t32btnbg3 INTEGER, t32btnbg4 INTEGER)";

    //Topic Four Pre-Test Table
    public static final String TABLE10_NAME = "T4PreTestResult";
    private static final String t4PreTestResultTable = "CREATE TABLE " + TABLE10_NAME + "(t41Id INTEGER PRIMARY KEY AUTOINCREMENT, t41questions TEXT, t41btn1 TEXT, t41btn2 TEXT, t41btn3 TEXT, t41btn4 TEXT, t41solution TEXT, t41answer TEXT, t41mark INTEGER, t41btnbg1 INTEGER, t41btnbg2 INTEGER, t41btnbg3 INTEGER, t41btnbg4 INTEGER)";

    //Topic Four Post-Test Table
    public static final String TABLE11_NAME = "T4PostTestResult";
    private static final String t4PostTestResultTable = "CREATE TABLE " + TABLE11_NAME + "(t42Id INTEGER PRIMARY KEY AUTOINCREMENT, t42questions TEXT, t42btn1 TEXT, t42btn2 TEXT, t42btn3 TEXT, t42btn4 TEXT, t42solution TEXT, t42answer TEXT, t42mark INTEGER, t42btnbg1 INTEGER, t42btnbg2 INTEGER, t42btnbg3 INTEGER, t42btnbg4 INTEGER)";

    //Topic Five Pre-Test Table
    public static final String TABLE12_NAME = "T5PreTestResult";
    private static final String t5PreTestResultTable = "CREATE TABLE " + TABLE12_NAME + "(t51Id INTEGER PRIMARY KEY AUTOINCREMENT, t51questions TEXT, t51btn1 TEXT, t51btn2 TEXT, t51btn3 TEXT, t51btn4 TEXT, t51solution TEXT, t51answer TEXT, t51mark INTEGER, t51btnbg1 INTEGER, t51btnbg2 INTEGER, t51btnbg3 INTEGER, t51btnbg4 INTEGER)";

    //Topic Five Post-Test Table
    public static final String TABLE13_NAME = "T5PostTestResult";
    private static final String t5PostTestResultTable = "CREATE TABLE " + TABLE13_NAME + "(t52Id INTEGER PRIMARY KEY AUTOINCREMENT, t52questions TEXT, t52btn1 TEXT, t52btn2 TEXT, t52btn3 TEXT, t52btn4 TEXT, t52solution TEXT, t52answer TEXT, t52mark INTEGER, t52btnbg1 INTEGER, t52btnbg2 INTEGER, t52btnbg3 INTEGER, t52btnbg4 INTEGER)";

    //Topic Six Pre-Test Table
    public static final String TABLE14_NAME = "T6PreTestResult";
    private static final String t6PreTestResultTable = "CREATE TABLE " + TABLE14_NAME + "(t61Id INTEGER PRIMARY KEY AUTOINCREMENT, t61questions TEXT, t61btn1 TEXT, t61btn2 TEXT, t61btn3 TEXT, t61btn4 TEXT, t61solution TEXT, t61answer TEXT, t61mark INTEGER, t61btnbg1 INTEGER, t61btnbg2 INTEGER, t61btnbg3 INTEGER, t61btnbg4 INTEGER)";

    //Topic Six Post-Test Table
    public static final String TABLE15_NAME = "T6PostTestResult";
    private static final String t6PostTestResultTable = "CREATE TABLE " + TABLE15_NAME + "(t62Id INTEGER PRIMARY KEY AUTOINCREMENT, t62questions TEXT, t62btn1 TEXT, t62btn2 TEXT, t62btn3 TEXT, t62btn4 TEXT, t62solution TEXT, t62answer TEXT, t62mark INTEGER, t62btnbg1 INTEGER, t62btnbg2 INTEGER, t62btnbg3 INTEGER, t62btnbg4 INTEGER)";

    //Topic Seven Pre-Test Table
    public static final String TABLE16_NAME = "T7PreTestResult";
    private static final String t7PreTestResultTable = "CREATE TABLE " + TABLE16_NAME + "(t71Id INTEGER PRIMARY KEY AUTOINCREMENT, t71questions TEXT, t71btn1 TEXT, t71btn2 TEXT, t71btn3 TEXT, t71btn4 TEXT, t71solution TEXT, t71answer TEXT, t71mark INTEGER, t71btnbg1 INTEGER, t71btnbg2 INTEGER, t71btnbg3 INTEGER, t71btnbg4 INTEGER)";

    //Topic Seven Post-Test Table
    public static final String TABLE17_NAME = "T7PostTestResult";
    private static final String t7PostTestResultTable = "CREATE TABLE " + TABLE17_NAME + "(t72Id INTEGER PRIMARY KEY AUTOINCREMENT, t72questions TEXT, t72btn1 TEXT, t72btn2 TEXT, t72btn3 TEXT, t72btn4 TEXT, t72solution TEXT, t72answer TEXT, t72mark INTEGER, t72btnbg1 INTEGER, t72btnbg2 INTEGER, t72btnbg3 INTEGER, t72btnbg4 INTEGER)";

    //Topic Eight Pre-Test Table
    public static final String TABLE18_NAME = "T8PreTestResult";
    private static final String t8PreTestResultTable = "CREATE TABLE " + TABLE18_NAME + "(t81Id INTEGER PRIMARY KEY AUTOINCREMENT, t81questions TEXT, t81btn1 TEXT, t81btn2 TEXT, t81btn3 TEXT, t81btn4 TEXT, t81solution TEXT, t81answer TEXT, t81mark INTEGER, t81btnbg1 INTEGER, t81btnbg2 INTEGER, t81btnbg3 INTEGER, t81btnbg4 INTEGER)";

    //Topic Eight Post-Test Table
    public static final String TABLE19_NAME = "T8PostTestResult";
    private static final String t8PostTestResultTable = "CREATE TABLE " + TABLE19_NAME + "(t82Id INTEGER PRIMARY KEY AUTOINCREMENT, t82questions TEXT, t82btn1 TEXT, t82btn2 TEXT, t82btn3 TEXT, t82btn4 TEXT, t82solution TEXT, t82answer TEXT, t82mark INTEGER, t82btnbg1 INTEGER, t82btnbg2 INTEGER, t82btnbg3 INTEGER, t82btnbg4 INTEGER)";

    //Topic Nine Pre-Test Table
    public static final String TABLE20_NAME = "T9PreTestResult";
    private static final String t9PreTestResultTable = "CREATE TABLE " + TABLE20_NAME + "(t91Id INTEGER PRIMARY KEY AUTOINCREMENT, t91questions TEXT, t91btn1 TEXT, t91btn2 TEXT, t91btn3 TEXT, t91btn4 TEXT, t91solution TEXT, t91answer TEXT, t91mark INTEGER, t91btnbg1 INTEGER, t91btnbg2 INTEGER, t91btnbg3 INTEGER, t91btnbg4 INTEGER)";

    //Topic Nine Post-Test Table
    public static final String TABLE21_NAME = "T9PostTestResult";
    private static final String t9PostTestResultTable = "CREATE TABLE " + TABLE21_NAME + "(t92Id INTEGER PRIMARY KEY AUTOINCREMENT, t92questions TEXT, t92btn1 TEXT, t92btn2 TEXT, t92btn3 TEXT, t92btn4 TEXT, t92solution TEXT, t92answer TEXT, t92mark INTEGER, t92btnbg1 INTEGER, t92btnbg2 INTEGER, t92btnbg3 INTEGER, t92btnbg4 INTEGER)";

    //Topic Ten Pre-Test Table
    public static final String TABLE22_NAME = "t10PreTestResult";
    private static final String t10PreTestResultTable = "CREATE TABLE " + TABLE22_NAME + "(t101Id INTEGER PRIMARY KEY AUTOINCREMENT, t101questions TEXT, t101btn1 TEXT, t101btn2 TEXT, t101btn3 TEXT, t101btn4 TEXT, t101solution TEXT, t101answer TEXT, t101mark INTEGER, t101btnbg1 INTEGER, t101btnbg2 INTEGER, t101btnbg3 INTEGER, t101btnbg4 INTEGER)";

    //Topic Ten Post-Test Table
    public static final String TABLE23_NAME = "t10PostTestResult";
    private static final String t10PostTestResultTable = "CREATE TABLE " + TABLE23_NAME + "(t102Id INTEGER PRIMARY KEY AUTOINCREMENT, t102questions TEXT, t102btn1 TEXT, t102btn2 TEXT, t102btn3 TEXT, t102btn4 TEXT, t102solution TEXT, t102answer TEXT, t102mark INTEGER, t102btnbg1 INTEGER, t102btnbg2 INTEGER, t102btnbg3 INTEGER, t102btnbg4 INTEGER)";

    //Topic Eleven Pre-Test Table
    public static final String TABLE24_NAME = "t11PreTestResult";
    private static final String t11PreTestResultTable = "CREATE TABLE " + TABLE24_NAME + "(t111Id INTEGER PRIMARY KEY AUTOINCREMENT, t111questions TEXT, t111btn1 TEXT, t111btn2 TEXT, t111btn3 TEXT, t111btn4 TEXT, t111solution TEXT, t111answer TEXT, t111mark INTEGER, t111btnbg1 INTEGER, t111btnbg2 INTEGER, t111btnbg3 INTEGER, t111btnbg4 INTEGER)";

    //Topic Eleven Post-Test Table
    public static final String TABLE25_NAME = "t11PostTestResult";
    private static final String t11PostTestResultTable = "CREATE TABLE " + TABLE25_NAME + "(t112Id INTEGER PRIMARY KEY AUTOINCREMENT, t112questions TEXT, t112btn1 TEXT, t112btn2 TEXT, t112btn3 TEXT, t112btn4 TEXT, t112solution TEXT, t112answer TEXT, t112mark INTEGER, t112btnbg1 INTEGER, t112btnbg2 INTEGER, t112btnbg3 INTEGER, t112btnbg4 INTEGER)";

    //Topic Twelve Pre-Test Table
    public static final String TABLE26_NAME = "t12PreTestResult";
    private static final String t12PreTestResultTable = "CREATE TABLE " + TABLE26_NAME + "(t121Id INTEGER PRIMARY KEY AUTOINCREMENT, t121questions TEXT, t121btn1 TEXT, t121btn2 TEXT, t121btn3 TEXT, t121btn4 TEXT, t121solution TEXT, t121answer TEXT, t121mark INTEGER, t121btnbg1 INTEGER, t121btnbg2 INTEGER, t121btnbg3 INTEGER, t121btnbg4 INTEGER)";

    //Topic Twelve Post-Test Table
    public static final String TABLE27_NAME = "t12PostTestResult";
    private static final String t12PostTestResultTable = "CREATE TABLE " + TABLE27_NAME + "(t122Id INTEGER PRIMARY KEY AUTOINCREMENT, t122questions TEXT, t122btn1 TEXT, t122btn2 TEXT, t122btn3 TEXT, t122btn4 TEXT, t122solution TEXT, t122answer TEXT, t122mark INTEGER, t122btnbg1 INTEGER, t122btnbg2 INTEGER, t122btnbg3 INTEGER, t122btnbg4 INTEGER)";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(testsTable);
        db.execSQL(profileTable);
        db.execSQL(studyTimeTable);
        db.execSQL(t1PreTestResultTable);
        db.execSQL(t1PostTestResultTable);
        db.execSQL(t2PreTestResultTable);
        db.execSQL(t2PostTestResultTable);
        db.execSQL(t3PreTestResultTable);
        db.execSQL(t3PostTestResultTable);
        db.execSQL(t4PreTestResultTable);
        db.execSQL(t4PostTestResultTable);
        db.execSQL(t5PreTestResultTable);
        db.execSQL(t5PostTestResultTable);
        db.execSQL(t6PreTestResultTable);
        db.execSQL(t6PostTestResultTable);
        db.execSQL(t7PreTestResultTable);
        db.execSQL(t7PostTestResultTable);
        db.execSQL(t8PreTestResultTable);
        db.execSQL(t8PostTestResultTable);
        db.execSQL(t9PreTestResultTable);
        db.execSQL(t9PostTestResultTable);
        db.execSQL(t10PreTestResultTable);
        db.execSQL(t10PostTestResultTable);
        db.execSQL(t11PreTestResultTable);
        db.execSQL(t11PostTestResultTable);
        db.execSQL(t12PreTestResultTable);
        db.execSQL(t12PostTestResultTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE2_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE3_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE4_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE5_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE6_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE7_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE8_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE9_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE10_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE11_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE12_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE13_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE14_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE15_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE16_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE17_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE18_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE19_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE20_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE21_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE22_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE23_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE24_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE25_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE26_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE27_NAME);
        onCreate(db);
    }

    // For Tests Scores
    public void storeTestScore(TestsModelClass testsModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TEST_CODE, testsModelClass.getTestCode());
        contentValues.put(SCORE, testsModelClass.getScore());
        contentValues.put(TIME, testsModelClass.getTime());

        long checkQuery = db.insert(TABLE1_NAME, null, contentValues);

        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public Map<String, String> getScoreTime(int testCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Map<String, String> scoreAndTime = new HashMap<>();
        String[] columns = {SCORE, TIME};
        String selection = TEST_CODE + " = ?";
        String[] selectionArgs = {String.valueOf(testCode)};
        Cursor cursor = db.query(TABLE1_NAME, columns, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            int scoreIndex = cursor.getColumnIndex(SCORE);
            int timeIndex = cursor.getColumnIndex(TIME);
            String score = cursor.getString(scoreIndex);
            String time = cursor.getString(timeIndex);
            scoreAndTime.put(SCORE, String.valueOf(score));
            scoreAndTime.put(TIME, time);
        }
        return scoreAndTime;
    }
    public Boolean checkCode(Integer testCode) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE1_NAME + " where " + TEST_CODE + " = ?", new String[]{String.valueOf(testCode)});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // For User Profile
    public void storeData(ProfileModelClass profileModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap bitmapImage = profileModelClass.getImage();

        byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
        byteImage = byteArrayOutputStream.toByteArray();

        ContentValues contentValues = new ContentValues();
        contentValues.put("fname", profileModelClass.getFname());
        contentValues.put("lname", profileModelClass.getLname());
        contentValues.put("section", profileModelClass.getSection());
        contentValues.put("image", byteImage);

        long checkQuery = db.insert(TABLE2_NAME, null, contentValues);

        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public Cursor getUser(int profileId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectArgs = { String.valueOf(profileId) };
        Cursor cursor = db.rawQuery("SELECT * FROM UserProfile WHERE profileId = ? LIMIT 1", selectArgs);

        return cursor;
    }
    public Boolean checkId(Integer profileId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE2_NAME + " where profileId = ?", new String[]{String.valueOf(profileId)});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean updateProfile(ProfileModelClass profileModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE2_NAME + " where profileId = ?", new String[]{String.valueOf(profileModelClass.getProfileId())});

        if (cursor.getCount() > 0) {
            Bitmap bitmapImage = profileModelClass.getImage();
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byteImage = byteArrayOutputStream.toByteArray();

            ContentValues contentValues = new ContentValues();
            contentValues.put("fname", profileModelClass.getFname());
            contentValues.put("lname", profileModelClass.getLname());
            contentValues.put("section", profileModelClass.getSection());
            contentValues.put("image", byteImage);

            long result = db.update(TABLE2_NAME, contentValues, " profileId = ?", new String[]{String.valueOf(profileModelClass.getProfileId())});

            db.close();

            return result != -1;
        } else {
            db.close();
            return false;
        }
    }

    //Topics TIme
    public void storeStudyTime(StudyModelClass studyModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TOPICS_ID, studyModelClass.getTopicsId());
        contentValues.put(TIME_IN_SEC, studyModelClass.getTimeSec());

        long checkQuery = db.insert(TABLE3_NAME, null, contentValues);

        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
    public Map<String, String> getTopicsId(int topicsId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Map<String, String> timeInSec = new HashMap<>();
        String[] column = {TIME_IN_SEC};
        String selection = TOPICS_ID + " = ?";
        String[] selectionArgs = {String.valueOf(topicsId)};
        Cursor cursor = db.query(TABLE3_NAME, column, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            int timeSecsIndex = cursor.getColumnIndex(TIME_IN_SEC);
            String timeSecs = cursor.getString(timeSecsIndex);
            timeInSec.put(TIME_IN_SEC, String.valueOf(timeSecs));
        }
        return timeInSec;
    }
    public Boolean checkTopicsId(int topicsId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE3_NAME + " where " + TOPICS_ID + " = ?", new String[]{String.valueOf(topicsId)});

        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public Boolean updateTime(StudyModelClass studyModelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE3_NAME + " where "+ TOPICS_ID + " = ?", new String[]{String.valueOf(studyModelClass.getTopicsId())});

        if (cursor.getCount() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TIME_IN_SEC, studyModelClass.getTimeSec());
            long result = db.update(TABLE3_NAME, contentValues, TOPICS_ID + " = ?", new String[]{String.valueOf(studyModelClass.getTopicsId())});
            db.close();
            return result != -1;
        } else {
            db.close();
            return false;
        }
    }

    //T1 Pre-Test Result
    public void storeT11Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t11questions", testResult.getTestQuestion());
        contentValues.put("t11btn1", testResult.getBtn1());
        contentValues.put("t11btn2", testResult.getBtn2());
        contentValues.put("t11btn3", testResult.getBtn3());
        contentValues.put("t11btn4", testResult.getBtn4());
        contentValues.put("t11solution", testResult.getTestSolution());
        contentValues.put("t11answer", testResult.getTestAnswer());
        contentValues.put("t11mark", testResult.getMark());
        contentValues.put("t11btnbg1", testResult.getBtnbg1());
        contentValues.put("t11btnbg2", testResult.getBtnbg2());
        contentValues.put("t11btnbg3", testResult.getBtnbg3());
        contentValues.put("t11btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE4_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT11Result(int t11Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t11Id", "t11questions", "t11btn1", "t11btn2", "t11btn3", "t11btn4", "t11solution", "t11answer", "t11mark", "t11btnbg1", "t11btnbg2", "t11btnbg3", "t11btnbg4"};
        String selection = "t11Id = ?";
        String[] selectionArgs = {String.valueOf(t11Id)};

        Cursor cursor = db.query(TABLE4_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t11questions");
            int btn1Index = cursor.getColumnIndex("t11btn1");
            int btn2Index = cursor.getColumnIndex("t11btn2");
            int btn3Index = cursor.getColumnIndex("t11btn3");
            int btn4Index = cursor.getColumnIndex("t11btn4");
            int solutionIndex = cursor.getColumnIndex("t11solution");
            int answerIndex = cursor.getColumnIndex("t11answer");
            int markIndex = cursor.getColumnIndex("t11mark");
            int btnbg1Index = cursor.getColumnIndex("t11btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t11btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t11btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t11btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T1 Post-Test Result
    public void storeT12Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t12questions", testResult.getTestQuestion());
        contentValues.put("t12btn1", testResult.getBtn1());
        contentValues.put("t12btn2", testResult.getBtn2());
        contentValues.put("t12btn3", testResult.getBtn3());
        contentValues.put("t12btn4", testResult.getBtn4());
        contentValues.put("t12solution", testResult.getTestSolution());
        contentValues.put("t12answer", testResult.getTestAnswer());
        contentValues.put("t12mark", testResult.getMark());
        contentValues.put("t12btnbg1", testResult.getBtnbg1());
        contentValues.put("t12btnbg2", testResult.getBtnbg2());
        contentValues.put("t12btnbg3", testResult.getBtnbg3());
        contentValues.put("t12btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE5_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT12Result(int t12Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t12Id", "t12questions", "t12btn1", "t12btn2", "t12btn3", "t12btn4", "t12solution", "t12answer", "t12mark", "t12btnbg1", "t12btnbg2", "t12btnbg3", "t12btnbg4"};
        String selection = "t12Id = ?";
        String[] selectionArgs = {String.valueOf(t12Id)};

        Cursor cursor = db.query(TABLE5_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t12questions");
            int btn1Index = cursor.getColumnIndex("t12btn1");
            int btn2Index = cursor.getColumnIndex("t12btn2");
            int btn3Index = cursor.getColumnIndex("t12btn3");
            int btn4Index = cursor.getColumnIndex("t12btn4");
            int solutionIndex = cursor.getColumnIndex("t12solution");
            int answerIndex = cursor.getColumnIndex("t12answer");
            int markIndex = cursor.getColumnIndex("t12mark");
            int btnbg1Index = cursor.getColumnIndex("t12btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t12btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t12btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t12btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T2 Pre-Test Result
    public void storeT21Result(T2TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t21questions", testResult.getT2TestQuestion());
        contentValues.put("t21mark", testResult.getT2Mark());
        contentValues.put("t21btnbg1", testResult.getT2Btnbg1());
        contentValues.put("t21btnbg2", testResult.getT2Btnbg2());

        long checkQuery = db.insert(TABLE6_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public T2TestResultModelClass getT21Result(int t21Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        T2TestResultModelClass testResult = new T2TestResultModelClass();

        String[] columns = {"t21Id", "t21questions", "t21mark", "t21btnbg1", "t21btnbg2"};
        String selection = "t21Id = ?";
        String[] selectionArgs = {String.valueOf(t21Id)};

        Cursor cursor = db.query(TABLE6_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t21questions");
            int markIndex = cursor.getColumnIndex("t21mark");
            int btnbg1Index = cursor.getColumnIndex("t21btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t21btnbg2");
            testResult.setT2TestQuestion(cursor.getString(questionIndex));
            testResult.setT2Mark(cursor.getInt(markIndex));
            testResult.setT2Btnbg1(cursor.getInt(btnbg1Index));
            testResult.setT2Btnbg2(cursor.getInt(btnbg2Index));
            cursor.close();
        }
        return testResult;
    }

    //T2 Post-Test Result
    public void storeT22Result(T2TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t22questions", testResult.getT2TestQuestion());
        contentValues.put("t22mark", testResult.getT2Mark());
        contentValues.put("t22btnbg1", testResult.getT2Btnbg1());
        contentValues.put("t22btnbg2", testResult.getT2Btnbg2());

        long checkQuery = db.insert(TABLE7_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public T2TestResultModelClass getT22Result(int t22Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        T2TestResultModelClass testResult = new T2TestResultModelClass();

        String[] columns = {"t22Id", "t22questions", "t22mark", "t22btnbg1", "t22btnbg2"};
        String selection = "t22Id = ?";
        String[] selectionArgs = {String.valueOf(t22Id)};

        Cursor cursor = db.query(TABLE7_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t22questions");
            int markIndex = cursor.getColumnIndex("t22mark");
            int btnbg1Index = cursor.getColumnIndex("t22btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t22btnbg2");
            testResult.setT2TestQuestion(cursor.getString(questionIndex));
            testResult.setT2Mark(cursor.getInt(markIndex));
            testResult.setT2Btnbg1(cursor.getInt(btnbg1Index));
            testResult.setT2Btnbg2(cursor.getInt(btnbg2Index));
            cursor.close();
        }
        return testResult;
    }

    //T3 Pre-Test Result
    public void storeT31Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t31questions", testResult.getTestQuestion());
        contentValues.put("t31btn1", testResult.getBtn1());
        contentValues.put("t31btn2", testResult.getBtn2());
        contentValues.put("t31btn3", testResult.getBtn3());
        contentValues.put("t31btn4", testResult.getBtn4());
        contentValues.put("t31solution", testResult.getTestSolution());
        contentValues.put("t31answer", testResult.getTestAnswer());
        contentValues.put("t31mark", testResult.getMark());
        contentValues.put("t31btnbg1", testResult.getBtnbg1());
        contentValues.put("t31btnbg2", testResult.getBtnbg2());
        contentValues.put("t31btnbg3", testResult.getBtnbg3());
        contentValues.put("t31btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE8_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT31Result(int t31Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t31Id", "t31questions", "t31btn1", "t31btn2", "t31btn3", "t31btn4", "t31solution", "t31answer", "t31mark", "t31btnbg1", "t31btnbg2", "t31btnbg3", "t31btnbg4"};
        String selection = "t31Id = ?";
        String[] selectionArgs = {String.valueOf(t31Id)};

        Cursor cursor = db.query(TABLE8_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t31questions");
            int btn1Index = cursor.getColumnIndex("t31btn1");
            int btn2Index = cursor.getColumnIndex("t31btn2");
            int btn3Index = cursor.getColumnIndex("t31btn3");
            int btn4Index = cursor.getColumnIndex("t31btn4");
            int solutionIndex = cursor.getColumnIndex("t31solution");
            int answerIndex = cursor.getColumnIndex("t31answer");
            int markIndex = cursor.getColumnIndex("t31mark");
            int btnbg1Index = cursor.getColumnIndex("t31btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t31btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t31btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t31btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T3 Post-Test Result
    public void storeT32Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t32questions", testResult.getTestQuestion());
        contentValues.put("t32btn1", testResult.getBtn1());
        contentValues.put("t32btn2", testResult.getBtn2());
        contentValues.put("t32btn3", testResult.getBtn3());
        contentValues.put("t32btn4", testResult.getBtn4());
        contentValues.put("t32solution", testResult.getTestSolution());
        contentValues.put("t32answer", testResult.getTestAnswer());
        contentValues.put("t32mark", testResult.getMark());
        contentValues.put("t32btnbg1", testResult.getBtnbg1());
        contentValues.put("t32btnbg2", testResult.getBtnbg2());
        contentValues.put("t32btnbg3", testResult.getBtnbg3());
        contentValues.put("t32btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE9_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT32Result(int t32Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t32Id", "t32questions", "t32btn1", "t32btn2", "t32btn3", "t32btn4", "t32solution", "t32answer", "t32mark", "t32btnbg1", "t32btnbg2", "t32btnbg3", "t32btnbg4"};
        String selection = "t32Id = ?";
        String[] selectionArgs = {String.valueOf(t32Id)};

        Cursor cursor = db.query(TABLE9_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t32questions");
            int btn1Index = cursor.getColumnIndex("t32btn1");
            int btn2Index = cursor.getColumnIndex("t32btn2");
            int btn3Index = cursor.getColumnIndex("t32btn3");
            int btn4Index = cursor.getColumnIndex("t32btn4");
            int solutionIndex = cursor.getColumnIndex("t32solution");
            int answerIndex = cursor.getColumnIndex("t32answer");
            int markIndex = cursor.getColumnIndex("t32mark");
            int btnbg1Index = cursor.getColumnIndex("t32btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t32btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t32btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t32btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T4 Pre-Test Result
    public void storeT41Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t41questions", testResult.getTestQuestion());
        contentValues.put("t41btn1", testResult.getBtn1());
        contentValues.put("t41btn2", testResult.getBtn2());
        contentValues.put("t41btn3", testResult.getBtn3());
        contentValues.put("t41btn4", testResult.getBtn4());
        contentValues.put("t41solution", testResult.getTestSolution());
        contentValues.put("t41answer", testResult.getTestAnswer());
        contentValues.put("t41mark", testResult.getMark());
        contentValues.put("t41btnbg1", testResult.getBtnbg1());
        contentValues.put("t41btnbg2", testResult.getBtnbg2());
        contentValues.put("t41btnbg3", testResult.getBtnbg3());
        contentValues.put("t41btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE10_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT41Result(int t41Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t41Id", "t41questions", "t41btn1", "t41btn2", "t41btn3", "t41btn4", "t41solution", "t41answer", "t41mark", "t41btnbg1", "t41btnbg2", "t41btnbg3", "t41btnbg4"};
        String selection = "t41Id = ?";
        String[] selectionArgs = {String.valueOf(t41Id)};

        Cursor cursor = db.query(TABLE10_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t41questions");
            int btn1Index = cursor.getColumnIndex("t41btn1");
            int btn2Index = cursor.getColumnIndex("t41btn2");
            int btn3Index = cursor.getColumnIndex("t41btn3");
            int btn4Index = cursor.getColumnIndex("t41btn4");
            int solutionIndex = cursor.getColumnIndex("t41solution");
            int answerIndex = cursor.getColumnIndex("t41answer");
            int markIndex = cursor.getColumnIndex("t41mark");
            int btnbg1Index = cursor.getColumnIndex("t41btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t41btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t41btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t41btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T4 Post-Test Result
    public void storeT42Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t42questions", testResult.getTestQuestion());
        contentValues.put("t42btn1", testResult.getBtn1());
        contentValues.put("t42btn2", testResult.getBtn2());
        contentValues.put("t42btn3", testResult.getBtn3());
        contentValues.put("t42btn4", testResult.getBtn4());
        contentValues.put("t42solution", testResult.getTestSolution());
        contentValues.put("t42answer", testResult.getTestAnswer());
        contentValues.put("t42mark", testResult.getMark());
        contentValues.put("t42btnbg1", testResult.getBtnbg1());
        contentValues.put("t42btnbg2", testResult.getBtnbg2());
        contentValues.put("t42btnbg3", testResult.getBtnbg3());
        contentValues.put("t42btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE11_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT42Result(int t42Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t42Id", "t42questions", "t42btn1", "t42btn2", "t42btn3", "t42btn4", "t42solution", "t42answer", "t42mark", "t42btnbg1", "t42btnbg2", "t42btnbg3", "t42btnbg4"};
        String selection = "t42Id = ?";
        String[] selectionArgs = {String.valueOf(t42Id)};

        Cursor cursor = db.query(TABLE11_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t42questions");
            int btn1Index = cursor.getColumnIndex("t42btn1");
            int btn2Index = cursor.getColumnIndex("t42btn2");
            int btn3Index = cursor.getColumnIndex("t42btn3");
            int btn4Index = cursor.getColumnIndex("t42btn4");
            int solutionIndex = cursor.getColumnIndex("t42solution");
            int answerIndex = cursor.getColumnIndex("t42answer");
            int markIndex = cursor.getColumnIndex("t42mark");
            int btnbg1Index = cursor.getColumnIndex("t42btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t42btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t42btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t42btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T5 Pre-Test Result
    public void storeT51Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t51questions", testResult.getTestQuestion());
        contentValues.put("t51btn1", testResult.getBtn1());
        contentValues.put("t51btn2", testResult.getBtn2());
        contentValues.put("t51btn3", testResult.getBtn3());
        contentValues.put("t51btn4", testResult.getBtn4());
        contentValues.put("t51solution", testResult.getTestSolution());
        contentValues.put("t51answer", testResult.getTestAnswer());
        contentValues.put("t51mark", testResult.getMark());
        contentValues.put("t51btnbg1", testResult.getBtnbg1());
        contentValues.put("t51btnbg2", testResult.getBtnbg2());
        contentValues.put("t51btnbg3", testResult.getBtnbg3());
        contentValues.put("t51btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE12_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT51Result(int t51Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t51Id", "t51questions", "t51btn1", "t51btn2", "t51btn3", "t51btn4", "t51solution", "t51answer", "t51mark", "t51btnbg1", "t51btnbg2", "t51btnbg3", "t51btnbg4"};
        String selection = "t51Id = ?";
        String[] selectionArgs = {String.valueOf(t51Id)};

        Cursor cursor = db.query(TABLE12_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t51questions");
            int btn1Index = cursor.getColumnIndex("t51btn1");
            int btn2Index = cursor.getColumnIndex("t51btn2");
            int btn3Index = cursor.getColumnIndex("t51btn3");
            int btn4Index = cursor.getColumnIndex("t51btn4");
            int solutionIndex = cursor.getColumnIndex("t51solution");
            int answerIndex = cursor.getColumnIndex("t51answer");
            int markIndex = cursor.getColumnIndex("t51mark");
            int btnbg1Index = cursor.getColumnIndex("t51btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t51btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t51btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t51btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T5 Post-Test Result
    public void storeT52Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t52questions", testResult.getTestQuestion());
        contentValues.put("t52btn1", testResult.getBtn1());
        contentValues.put("t52btn2", testResult.getBtn2());
        contentValues.put("t52btn3", testResult.getBtn3());
        contentValues.put("t52btn4", testResult.getBtn4());
        contentValues.put("t52solution", testResult.getTestSolution());
        contentValues.put("t52answer", testResult.getTestAnswer());
        contentValues.put("t52mark", testResult.getMark());
        contentValues.put("t52btnbg1", testResult.getBtnbg1());
        contentValues.put("t52btnbg2", testResult.getBtnbg2());
        contentValues.put("t52btnbg3", testResult.getBtnbg3());
        contentValues.put("t52btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE13_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT52Result(int t52Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t52Id", "t52questions", "t52btn1", "t52btn2", "t52btn3", "t52btn4", "t52solution", "t52answer", "t52mark", "t52btnbg1", "t52btnbg2", "t52btnbg3", "t52btnbg4"};
        String selection = "t52Id = ?";
        String[] selectionArgs = {String.valueOf(t52Id)};

        Cursor cursor = db.query(TABLE13_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t52questions");
            int btn1Index = cursor.getColumnIndex("t52btn1");
            int btn2Index = cursor.getColumnIndex("t52btn2");
            int btn3Index = cursor.getColumnIndex("t52btn3");
            int btn4Index = cursor.getColumnIndex("t52btn4");
            int solutionIndex = cursor.getColumnIndex("t52solution");
            int answerIndex = cursor.getColumnIndex("t52answer");
            int markIndex = cursor.getColumnIndex("t52mark");
            int btnbg1Index = cursor.getColumnIndex("t52btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t52btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t52btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t52btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T6 Pre-Test Result
    public void storeT61Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t61questions", testResult.getTestQuestion());
        contentValues.put("t61btn1", testResult.getBtn1());
        contentValues.put("t61btn2", testResult.getBtn2());
        contentValues.put("t61btn3", testResult.getBtn3());
        contentValues.put("t61btn4", testResult.getBtn4());
        contentValues.put("t61solution", testResult.getTestSolution());
        contentValues.put("t61answer", testResult.getTestAnswer());
        contentValues.put("t61mark", testResult.getMark());
        contentValues.put("t61btnbg1", testResult.getBtnbg1());
        contentValues.put("t61btnbg2", testResult.getBtnbg2());
        contentValues.put("t61btnbg3", testResult.getBtnbg3());
        contentValues.put("t61btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE14_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT61Result(int t61Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t61Id", "t61questions", "t61btn1", "t61btn2", "t61btn3", "t61btn4", "t61solution", "t61answer", "t61mark", "t61btnbg1", "t61btnbg2", "t61btnbg3", "t61btnbg4"};
        String selection = "t61Id = ?";
        String[] selectionArgs = {String.valueOf(t61Id)};

        Cursor cursor = db.query(TABLE14_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t61questions");
            int btn1Index = cursor.getColumnIndex("t61btn1");
            int btn2Index = cursor.getColumnIndex("t61btn2");
            int btn3Index = cursor.getColumnIndex("t61btn3");
            int btn4Index = cursor.getColumnIndex("t61btn4");
            int solutionIndex = cursor.getColumnIndex("t61solution");
            int answerIndex = cursor.getColumnIndex("t61answer");
            int markIndex = cursor.getColumnIndex("t61mark");
            int btnbg1Index = cursor.getColumnIndex("t61btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t61btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t61btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t61btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T6 Post-Test Result
    public void storeT62Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t62questions", testResult.getTestQuestion());
        contentValues.put("t62btn1", testResult.getBtn1());
        contentValues.put("t62btn2", testResult.getBtn2());
        contentValues.put("t62btn3", testResult.getBtn3());
        contentValues.put("t62btn4", testResult.getBtn4());
        contentValues.put("t62solution", testResult.getTestSolution());
        contentValues.put("t62answer", testResult.getTestAnswer());
        contentValues.put("t62mark", testResult.getMark());
        contentValues.put("t62btnbg1", testResult.getBtnbg1());
        contentValues.put("t62btnbg2", testResult.getBtnbg2());
        contentValues.put("t62btnbg3", testResult.getBtnbg3());
        contentValues.put("t62btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE15_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT62Result(int t62Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t62Id", "t62questions", "t62btn1", "t62btn2", "t62btn3", "t62btn4", "t62solution", "t62answer", "t62mark", "t62btnbg1", "t62btnbg2", "t62btnbg3", "t62btnbg4"};
        String selection = "t62Id = ?";
        String[] selectionArgs = {String.valueOf(t62Id)};

        Cursor cursor = db.query(TABLE15_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t62questions");
            int btn1Index = cursor.getColumnIndex("t62btn1");
            int btn2Index = cursor.getColumnIndex("t62btn2");
            int btn3Index = cursor.getColumnIndex("t62btn3");
            int btn4Index = cursor.getColumnIndex("t62btn4");
            int solutionIndex = cursor.getColumnIndex("t62solution");
            int answerIndex = cursor.getColumnIndex("t62answer");
            int markIndex = cursor.getColumnIndex("t62mark");
            int btnbg1Index = cursor.getColumnIndex("t62btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t62btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t62btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t62btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T7 Pre-Test Result
    public void storeT71Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t71questions", testResult.getTestQuestion());
        contentValues.put("t71btn1", testResult.getBtn1());
        contentValues.put("t71btn2", testResult.getBtn2());
        contentValues.put("t71btn3", testResult.getBtn3());
        contentValues.put("t71btn4", testResult.getBtn4());
        contentValues.put("t71solution", testResult.getTestSolution());
        contentValues.put("t71answer", testResult.getTestAnswer());
        contentValues.put("t71mark", testResult.getMark());
        contentValues.put("t71btnbg1", testResult.getBtnbg1());
        contentValues.put("t71btnbg2", testResult.getBtnbg2());
        contentValues.put("t71btnbg3", testResult.getBtnbg3());
        contentValues.put("t71btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE16_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT71Result(int t71Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t71Id", "t71questions", "t71btn1", "t71btn2", "t71btn3", "t71btn4", "t71solution", "t71answer", "t71mark", "t71btnbg1", "t71btnbg2", "t71btnbg3", "t71btnbg4"};
        String selection = "t71Id = ?";
        String[] selectionArgs = {String.valueOf(t71Id)};

        Cursor cursor = db.query(TABLE16_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t71questions");
            int btn1Index = cursor.getColumnIndex("t71btn1");
            int btn2Index = cursor.getColumnIndex("t71btn2");
            int btn3Index = cursor.getColumnIndex("t71btn3");
            int btn4Index = cursor.getColumnIndex("t71btn4");
            int solutionIndex = cursor.getColumnIndex("t71solution");
            int answerIndex = cursor.getColumnIndex("t71answer");
            int markIndex = cursor.getColumnIndex("t71mark");
            int btnbg1Index = cursor.getColumnIndex("t71btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t71btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t71btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t71btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T7 Post-Test Result
    public void storeT72Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t72questions", testResult.getTestQuestion());
        contentValues.put("t72btn1", testResult.getBtn1());
        contentValues.put("t72btn2", testResult.getBtn2());
        contentValues.put("t72btn3", testResult.getBtn3());
        contentValues.put("t72btn4", testResult.getBtn4());
        contentValues.put("t72solution", testResult.getTestSolution());
        contentValues.put("t72answer", testResult.getTestAnswer());
        contentValues.put("t72mark", testResult.getMark());
        contentValues.put("t72btnbg1", testResult.getBtnbg1());
        contentValues.put("t72btnbg2", testResult.getBtnbg2());
        contentValues.put("t72btnbg3", testResult.getBtnbg3());
        contentValues.put("t72btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE17_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT72Result(int t72Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t72Id", "t72questions", "t72btn1", "t72btn2", "t72btn3", "t72btn4", "t72solution", "t72answer", "t72mark", "t72btnbg1", "t72btnbg2", "t72btnbg3", "t72btnbg4"};
        String selection = "t72Id = ?";
        String[] selectionArgs = {String.valueOf(t72Id)};

        Cursor cursor = db.query(TABLE17_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t72questions");
            int btn1Index = cursor.getColumnIndex("t72btn1");
            int btn2Index = cursor.getColumnIndex("t72btn2");
            int btn3Index = cursor.getColumnIndex("t72btn3");
            int btn4Index = cursor.getColumnIndex("t72btn4");
            int solutionIndex = cursor.getColumnIndex("t72solution");
            int answerIndex = cursor.getColumnIndex("t72answer");
            int markIndex = cursor.getColumnIndex("t72mark");
            int btnbg1Index = cursor.getColumnIndex("t72btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t72btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t72btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t72btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T8 Pre-Test Result
    public void storeT81Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t81questions", testResult.getTestQuestion());
        contentValues.put("t81btn1", testResult.getBtn1());
        contentValues.put("t81btn2", testResult.getBtn2());
        contentValues.put("t81btn3", testResult.getBtn3());
        contentValues.put("t81btn4", testResult.getBtn4());
        contentValues.put("t81solution", testResult.getTestSolution());
        contentValues.put("t81answer", testResult.getTestAnswer());
        contentValues.put("t81mark", testResult.getMark());
        contentValues.put("t81btnbg1", testResult.getBtnbg1());
        contentValues.put("t81btnbg2", testResult.getBtnbg2());
        contentValues.put("t81btnbg3", testResult.getBtnbg3());
        contentValues.put("t81btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE18_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT81Result(int t81Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t81Id", "t81questions", "t81btn1", "t81btn2", "t81btn3", "t81btn4", "t81solution", "t81answer", "t81mark", "t81btnbg1", "t81btnbg2", "t81btnbg3", "t81btnbg4"};
        String selection = "t81Id = ?";
        String[] selectionArgs = {String.valueOf(t81Id)};

        Cursor cursor = db.query(TABLE18_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t81questions");
            int btn1Index = cursor.getColumnIndex("t81btn1");
            int btn2Index = cursor.getColumnIndex("t81btn2");
            int btn3Index = cursor.getColumnIndex("t81btn3");
            int btn4Index = cursor.getColumnIndex("t81btn4");
            int solutionIndex = cursor.getColumnIndex("t81solution");
            int answerIndex = cursor.getColumnIndex("t81answer");
            int markIndex = cursor.getColumnIndex("t81mark");
            int btnbg1Index = cursor.getColumnIndex("t81btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t81btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t81btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t81btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T7 Post-Test Result
    public void storeT82Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t82questions", testResult.getTestQuestion());
        contentValues.put("t82btn1", testResult.getBtn1());
        contentValues.put("t82btn2", testResult.getBtn2());
        contentValues.put("t82btn3", testResult.getBtn3());
        contentValues.put("t82btn4", testResult.getBtn4());
        contentValues.put("t82solution", testResult.getTestSolution());
        contentValues.put("t82answer", testResult.getTestAnswer());
        contentValues.put("t82mark", testResult.getMark());
        contentValues.put("t82btnbg1", testResult.getBtnbg1());
        contentValues.put("t82btnbg2", testResult.getBtnbg2());
        contentValues.put("t82btnbg3", testResult.getBtnbg3());
        contentValues.put("t82btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE19_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT82Result(int t82Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t82Id", "t82questions", "t82btn1", "t82btn2", "t82btn3", "t82btn4", "t82solution", "t82answer", "t82mark", "t82btnbg1", "t82btnbg2", "t82btnbg3", "t82btnbg4"};
        String selection = "t82Id = ?";
        String[] selectionArgs = {String.valueOf(t82Id)};

        Cursor cursor = db.query(TABLE19_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t82questions");
            int btn1Index = cursor.getColumnIndex("t82btn1");
            int btn2Index = cursor.getColumnIndex("t82btn2");
            int btn3Index = cursor.getColumnIndex("t82btn3");
            int btn4Index = cursor.getColumnIndex("t82btn4");
            int solutionIndex = cursor.getColumnIndex("t82solution");
            int answerIndex = cursor.getColumnIndex("t82answer");
            int markIndex = cursor.getColumnIndex("t82mark");
            int btnbg1Index = cursor.getColumnIndex("t82btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t82btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t82btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t82btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T9 Pre-Test Result
    public void storeT91Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t91questions", testResult.getTestQuestion());
        contentValues.put("t91btn1", testResult.getBtn1());
        contentValues.put("t91btn2", testResult.getBtn2());
        contentValues.put("t91btn3", testResult.getBtn3());
        contentValues.put("t91btn4", testResult.getBtn4());
        contentValues.put("t91solution", testResult.getTestSolution());
        contentValues.put("t91answer", testResult.getTestAnswer());
        contentValues.put("t91mark", testResult.getMark());
        contentValues.put("t91btnbg1", testResult.getBtnbg1());
        contentValues.put("t91btnbg2", testResult.getBtnbg2());
        contentValues.put("t91btnbg3", testResult.getBtnbg3());
        contentValues.put("t91btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE20_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT91Result(int t91Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t91Id", "t91questions", "t91btn1", "t91btn2", "t91btn3", "t91btn4", "t91solution", "t91answer", "t91mark", "t91btnbg1", "t91btnbg2", "t91btnbg3", "t91btnbg4"};
        String selection = "t91Id = ?";
        String[] selectionArgs = {String.valueOf(t91Id)};

        Cursor cursor = db.query(TABLE20_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t91questions");
            int btn1Index = cursor.getColumnIndex("t91btn1");
            int btn2Index = cursor.getColumnIndex("t91btn2");
            int btn3Index = cursor.getColumnIndex("t91btn3");
            int btn4Index = cursor.getColumnIndex("t91btn4");
            int solutionIndex = cursor.getColumnIndex("t91solution");
            int answerIndex = cursor.getColumnIndex("t91answer");
            int markIndex = cursor.getColumnIndex("t91mark");
            int btnbg1Index = cursor.getColumnIndex("t91btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t91btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t91btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t91btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T9 Post-Test Result
    public void storeT92Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t92questions", testResult.getTestQuestion());
        contentValues.put("t92btn1", testResult.getBtn1());
        contentValues.put("t92btn2", testResult.getBtn2());
        contentValues.put("t92btn3", testResult.getBtn3());
        contentValues.put("t92btn4", testResult.getBtn4());
        contentValues.put("t92solution", testResult.getTestSolution());
        contentValues.put("t92answer", testResult.getTestAnswer());
        contentValues.put("t92mark", testResult.getMark());
        contentValues.put("t92btnbg1", testResult.getBtnbg1());
        contentValues.put("t92btnbg2", testResult.getBtnbg2());
        contentValues.put("t92btnbg3", testResult.getBtnbg3());
        contentValues.put("t92btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE21_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT92Result(int t92Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t92Id", "t92questions", "t92btn1", "t92btn2", "t92btn3", "t92btn4", "t92solution", "t92answer", "t92mark", "t92btnbg1", "t92btnbg2", "t92btnbg3", "t92btnbg4"};
        String selection = "t92Id = ?";
        String[] selectionArgs = {String.valueOf(t92Id)};

        Cursor cursor = db.query(TABLE21_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t92questions");
            int btn1Index = cursor.getColumnIndex("t92btn1");
            int btn2Index = cursor.getColumnIndex("t92btn2");
            int btn3Index = cursor.getColumnIndex("t92btn3");
            int btn4Index = cursor.getColumnIndex("t92btn4");
            int solutionIndex = cursor.getColumnIndex("t92solution");
            int answerIndex = cursor.getColumnIndex("t92answer");
            int markIndex = cursor.getColumnIndex("t92mark");
            int btnbg1Index = cursor.getColumnIndex("t92btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t92btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t92btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t92btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T10 Pre-Test Result
    public void storeT101Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t101questions", testResult.getTestQuestion());
        contentValues.put("t101btn1", testResult.getBtn1());
        contentValues.put("t101btn2", testResult.getBtn2());
        contentValues.put("t101btn3", testResult.getBtn3());
        contentValues.put("t101btn4", testResult.getBtn4());
        contentValues.put("t101solution", testResult.getTestSolution());
        contentValues.put("t101answer", testResult.getTestAnswer());
        contentValues.put("t101mark", testResult.getMark());
        contentValues.put("t101btnbg1", testResult.getBtnbg1());
        contentValues.put("t101btnbg2", testResult.getBtnbg2());
        contentValues.put("t101btnbg3", testResult.getBtnbg3());
        contentValues.put("t101btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE22_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT101Result(int t101Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t101Id", "t101questions", "t101btn1", "t101btn2", "t101btn3", "t101btn4", "t101solution", "t101answer", "t101mark", "t101btnbg1", "t101btnbg2", "t101btnbg3", "t101btnbg4"};
        String selection = "t101Id = ?";
        String[] selectionArgs = {String.valueOf(t101Id)};

        Cursor cursor = db.query(TABLE22_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t101questions");
            int btn1Index = cursor.getColumnIndex("t101btn1");
            int btn2Index = cursor.getColumnIndex("t101btn2");
            int btn3Index = cursor.getColumnIndex("t101btn3");
            int btn4Index = cursor.getColumnIndex("t101btn4");
            int solutionIndex = cursor.getColumnIndex("t101solution");
            int answerIndex = cursor.getColumnIndex("t101answer");
            int markIndex = cursor.getColumnIndex("t101mark");
            int btnbg1Index = cursor.getColumnIndex("t101btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t101btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t101btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t101btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //T10 Post-Test Result
    public void storeT102Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t102questions", testResult.getTestQuestion());
        contentValues.put("t102btn1", testResult.getBtn1());
        contentValues.put("t102btn2", testResult.getBtn2());
        contentValues.put("t102btn3", testResult.getBtn3());
        contentValues.put("t102btn4", testResult.getBtn4());
        contentValues.put("t102solution", testResult.getTestSolution());
        contentValues.put("t102answer", testResult.getTestAnswer());
        contentValues.put("t102mark", testResult.getMark());
        contentValues.put("t102btnbg1", testResult.getBtnbg1());
        contentValues.put("t102btnbg2", testResult.getBtnbg2());
        contentValues.put("t102btnbg3", testResult.getBtnbg3());
        contentValues.put("t102btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE23_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT102Result(int t102Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t102Id", "t102questions", "t102btn1", "t102btn2", "t102btn3", "t102btn4", "t102solution", "t102answer", "t102mark", "t102btnbg1", "t102btnbg2", "t102btnbg3", "t102btnbg4"};
        String selection = "t102Id = ?";
        String[] selectionArgs = {String.valueOf(t102Id)};

        Cursor cursor = db.query(TABLE23_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t102questions");
            int btn1Index = cursor.getColumnIndex("t102btn1");
            int btn2Index = cursor.getColumnIndex("t102btn2");
            int btn3Index = cursor.getColumnIndex("t102btn3");
            int btn4Index = cursor.getColumnIndex("t102btn4");
            int solutionIndex = cursor.getColumnIndex("t102solution");
            int answerIndex = cursor.getColumnIndex("t102answer");
            int markIndex = cursor.getColumnIndex("t102mark");
            int btnbg1Index = cursor.getColumnIndex("t102btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t102btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t102btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t102btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //t11 Pre-Test Result
    public void storeT111Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t111questions", testResult.getTestQuestion());
        contentValues.put("t111btn1", testResult.getBtn1());
        contentValues.put("t111btn2", testResult.getBtn2());
        contentValues.put("t111btn3", testResult.getBtn3());
        contentValues.put("t111btn4", testResult.getBtn4());
        contentValues.put("t111solution", testResult.getTestSolution());
        contentValues.put("t111answer", testResult.getTestAnswer());
        contentValues.put("t111mark", testResult.getMark());
        contentValues.put("t111btnbg1", testResult.getBtnbg1());
        contentValues.put("t111btnbg2", testResult.getBtnbg2());
        contentValues.put("t111btnbg3", testResult.getBtnbg3());
        contentValues.put("t111btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE24_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT111Result(int t111Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t111Id", "t111questions", "t111btn1", "t111btn2", "t111btn3", "t111btn4", "t111solution", "t111answer", "t111mark", "t111btnbg1", "t111btnbg2", "t111btnbg3", "t111btnbg4"};
        String selection = "t111Id = ?";
        String[] selectionArgs = {String.valueOf(t111Id)};

        Cursor cursor = db.query(TABLE24_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t111questions");
            int btn1Index = cursor.getColumnIndex("t111btn1");
            int btn2Index = cursor.getColumnIndex("t111btn2");
            int btn3Index = cursor.getColumnIndex("t111btn3");
            int btn4Index = cursor.getColumnIndex("t111btn4");
            int solutionIndex = cursor.getColumnIndex("t111solution");
            int answerIndex = cursor.getColumnIndex("t111answer");
            int markIndex = cursor.getColumnIndex("t111mark");
            int btnbg1Index = cursor.getColumnIndex("t111btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t111btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t111btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t111btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //t11 Post-Test Result
    public void storeT112Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t112questions", testResult.getTestQuestion());
        contentValues.put("t112btn1", testResult.getBtn1());
        contentValues.put("t112btn2", testResult.getBtn2());
        contentValues.put("t112btn3", testResult.getBtn3());
        contentValues.put("t112btn4", testResult.getBtn4());
        contentValues.put("t112solution", testResult.getTestSolution());
        contentValues.put("t112answer", testResult.getTestAnswer());
        contentValues.put("t112mark", testResult.getMark());
        contentValues.put("t112btnbg1", testResult.getBtnbg1());
        contentValues.put("t112btnbg2", testResult.getBtnbg2());
        contentValues.put("t112btnbg3", testResult.getBtnbg3());
        contentValues.put("t112btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE25_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT112Result(int t112Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t112Id", "t112questions", "t112btn1", "t112btn2", "t112btn3", "t112btn4", "t112solution", "t112answer", "t112mark", "t112btnbg1", "t112btnbg2", "t112btnbg3", "t112btnbg4"};
        String selection = "t112Id = ?";
        String[] selectionArgs = {String.valueOf(t112Id)};

        Cursor cursor = db.query(TABLE25_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t112questions");
            int btn1Index = cursor.getColumnIndex("t112btn1");
            int btn2Index = cursor.getColumnIndex("t112btn2");
            int btn3Index = cursor.getColumnIndex("t112btn3");
            int btn4Index = cursor.getColumnIndex("t112btn4");
            int solutionIndex = cursor.getColumnIndex("t112solution");
            int answerIndex = cursor.getColumnIndex("t112answer");
            int markIndex = cursor.getColumnIndex("t112mark");
            int btnbg1Index = cursor.getColumnIndex("t112btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t112btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t112btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t112btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //t12 Pre-Test Result
    public void storeT121Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t121questions", testResult.getTestQuestion());
        contentValues.put("t121btn1", testResult.getBtn1());
        contentValues.put("t121btn2", testResult.getBtn2());
        contentValues.put("t121btn3", testResult.getBtn3());
        contentValues.put("t121btn4", testResult.getBtn4());
        contentValues.put("t121solution", testResult.getTestSolution());
        contentValues.put("t121answer", testResult.getTestAnswer());
        contentValues.put("t121mark", testResult.getMark());
        contentValues.put("t121btnbg1", testResult.getBtnbg1());
        contentValues.put("t121btnbg2", testResult.getBtnbg2());
        contentValues.put("t121btnbg3", testResult.getBtnbg3());
        contentValues.put("t121btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE26_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT121Result(int t121Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t121Id", "t121questions", "t121btn1", "t121btn2", "t121btn3", "t121btn4", "t121solution", "t121answer", "t121mark", "t121btnbg1", "t121btnbg2", "t121btnbg3", "t121btnbg4"};
        String selection = "t121Id = ?";
        String[] selectionArgs = {String.valueOf(t121Id)};

        Cursor cursor = db.query(TABLE26_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t121questions");
            int btn1Index = cursor.getColumnIndex("t121btn1");
            int btn2Index = cursor.getColumnIndex("t121btn2");
            int btn3Index = cursor.getColumnIndex("t121btn3");
            int btn4Index = cursor.getColumnIndex("t121btn4");
            int solutionIndex = cursor.getColumnIndex("t121solution");
            int answerIndex = cursor.getColumnIndex("t121answer");
            int markIndex = cursor.getColumnIndex("t121mark");
            int btnbg1Index = cursor.getColumnIndex("t121btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t121btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t121btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t121btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }

    //t12 Post-Test Result
    public void storeT122Result(TestResultModelClass testResult) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("t122questions", testResult.getTestQuestion());
        contentValues.put("t122btn1", testResult.getBtn1());
        contentValues.put("t122btn2", testResult.getBtn2());
        contentValues.put("t122btn3", testResult.getBtn3());
        contentValues.put("t122btn4", testResult.getBtn4());
        contentValues.put("t122solution", testResult.getTestSolution());
        contentValues.put("t122answer", testResult.getTestAnswer());
        contentValues.put("t122mark", testResult.getMark());
        contentValues.put("t122btnbg1", testResult.getBtnbg1());
        contentValues.put("t122btnbg2", testResult.getBtnbg2());
        contentValues.put("t122btnbg3", testResult.getBtnbg3());
        contentValues.put("t122btnbg4", testResult.getBtnbg4());

        long checkQuery = db.insert(TABLE27_NAME, null, contentValues);
        if (checkQuery != -1) {
            db.close();
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }

    public TestResultModelClass getT122Result(int t122Id) {
        SQLiteDatabase db = this.getReadableDatabase();
        TestResultModelClass testResult = new TestResultModelClass();

        String[] columns = {"t122Id", "t122questions", "t122btn1", "t122btn2", "t122btn3", "t122btn4", "t122solution", "t122answer", "t122mark", "t122btnbg1", "t122btnbg2", "t122btnbg3", "t122btnbg4"};
        String selection = "t122Id = ?";
        String[] selectionArgs = {String.valueOf(t122Id)};

        Cursor cursor = db.query(TABLE27_NAME, columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int questionIndex = cursor.getColumnIndex("t122questions");
            int btn1Index = cursor.getColumnIndex("t122btn1");
            int btn2Index = cursor.getColumnIndex("t122btn2");
            int btn3Index = cursor.getColumnIndex("t122btn3");
            int btn4Index = cursor.getColumnIndex("t122btn4");
            int solutionIndex = cursor.getColumnIndex("t122solution");
            int answerIndex = cursor.getColumnIndex("t122answer");
            int markIndex = cursor.getColumnIndex("t122mark");
            int btnbg1Index = cursor.getColumnIndex("t122btnbg1");
            int btnbg2Index = cursor.getColumnIndex("t122btnbg2");
            int btnbg3Index = cursor.getColumnIndex("t122btnbg3");
            int btnbg4Index = cursor.getColumnIndex("t122btnbg4");
            testResult.setTestQuestion(cursor.getString(questionIndex));
            testResult.setBtn1(cursor.getString(btn1Index));
            testResult.setBtn2(cursor.getString(btn2Index));
            testResult.setBtn3(cursor.getString(btn3Index));
            testResult.setBtn4(cursor.getString(btn4Index));
            testResult.setTestSolution(cursor.getString(solutionIndex));
            testResult.setTestAnswer(cursor.getString(answerIndex));
            testResult.setMark(cursor.getInt(markIndex));
            testResult.setBtnbg1(cursor.getInt(btnbg1Index));
            testResult.setBtnbg2(cursor.getInt(btnbg2Index));
            testResult.setBtnbg3(cursor.getInt(btnbg3Index));
            testResult.setBtnbg4(cursor.getInt(btnbg4Index));
            cursor.close();
        }
        return testResult;
    }
}
