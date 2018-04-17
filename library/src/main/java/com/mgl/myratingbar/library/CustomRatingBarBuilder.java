package com.mgl.myratingbar.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/4/12.
 */

public class CustomRatingBarBuilder extends LinearLayout {
    //    尺寸值
    private int starImageSize;
    //    星星间距
    private int starMargin;
    //    星星总数
    public int starCount;
    //    空白的星星资源文件值
    private int starEmpty;
    //    满星资源文件值
    private int starFull;
    //    半星资源文件值
    private int starHalf;
    //    是否可点击boolean值
    private boolean clickable;
    //    当前进度float值--星数
    private float initSelectValue;
    //    每次进度方式的值，整星还是半星
    private int stepWay;
    //    每颗星的分值
    private float valueOfEveryStar;

    private List<StarRecord> starImageViewList = new ArrayList<>();

    public CustomRatingBarBuilder(Context context) {
        super(context);
    }

    public CustomRatingBarBuilder(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomRatingBarStyle);
//
//        starImageSize = (int) dp2px(typedArray.getInt(R.styleable.CustomRatingBarStyle_starImageSize, 20), context);
//        starMargin = (int) dp2px(typedArray.getInt(R.styleable.CustomRatingBarStyle_starMargin, 5), context);
//        starCount = typedArray.getInt(R.styleable.CustomRatingBarStyle_starCount, 5);
//        starEmpty = typedArray.getResourceId(R.styleable.CustomRatingBarStyle_starEmpty, R.drawable.star3);
//        starFull = typedArray.getResourceId(R.styleable.CustomRatingBarStyle_starFull, R.drawable.star1);
//        starHalf = typedArray.getResourceId(R.styleable.CustomRatingBarStyle_starHalf, R.drawable.star2);
//        clickable = typedArray.getBoolean(R.styleable.CustomRatingBarStyle_clickable, true);
//        initSelectValue = typedArray.getFloat(R.styleable.CustomRatingBarStyle_initSelectValue, 0);
//        if (initSelectValue > starCount)
//            initSelectValue = starCount;
//        stepWay = typedArray.getInt(R.styleable.CustomRatingBarStyle_stepWay, 1);
//        valueOfEveryStar = typedArray.getFloat(R.styleable.CustomRatingBarStyle_valueOfEveryStar, 1);
//
//        typedArray.recycle();
//        initData(context);
    }

    public void invalidateView(Context context, Builder builder) {
        starImageSize = builder.starImageSize;
        starMargin = builder.starMargin;
        starCount = builder.starCount;
        starEmpty = builder.starEmpty;
        starFull = builder.starFull;
        starHalf = builder.starHalf;
        clickable = builder.clickable;
        initSelectValue = builder.initSelectValue;
        stepWay = builder.stepWay;
        valueOfEveryStar = builder.valueOfEveryStar;
        initData(context);
    }

    public class Builder {
        private Context context;
        //    尺寸值
        private int starImageSize;
        //    星星间距
        private int starMargin;
        //    星星总数
        public int starCount;
        //    空白的星星资源文件值
        private int starEmpty;
        //    满星资源文件值
        private int starFull;
        //    半星资源文件值
        private int starHalf;
        //    是否可点击boolean值
        private boolean clickable;
        //    当前进度float值--星数
        private float initSelectValue;
        //    每次进度方式的值，整星还是半星
        private int stepWay;
        //    每颗星的分值
        private float valueOfEveryStar;

        public Builder(Context context) {
            //可以设置必填条件的选项此处
            this.context = context;

            //    尺寸值
            starImageSize = (int) dp2px(20f, context);
            //    星星间距
            starMargin = (int) dp2px(5f, context);
            //    星星总数
            starCount = 5;
            //    空白的星星资源文件值
            starEmpty = R.drawable.star3;
            //    满星资源文件值
            starFull = R.drawable.star1;
            //    半星资源文件值
            starHalf = R.drawable.star2;
            //    是否可点击boolean值
            clickable = true;
            //    当前进度float值--星数
            initSelectValue = 0;
            //    每次进度方式的值，整星还是半星
            stepWay = 1;
            //    每颗星的分值
            valueOfEveryStar = 1;
        }

        //    尺寸值
        public Builder starImageSize(int starImageSize) {
            this.starImageSize = (int) dp2px(starImageSize, context);
            return this;
        }

        //    星星间距
        public Builder starMargin(int starMargin) {
            this.starMargin = (int) dp2px(starMargin, context);
            return this;
        }

        //    星星总数
        public Builder starCount(int starCount) {
            this.starCount = starCount;
            return this;
        }

        //    空白的星星资源文件值
        public Builder starEmpty(int starEmpty) {
            this.starEmpty = starEmpty;
            return this;
        }

        //    满星资源文件值
        public Builder starFull(int starFull) {
            this.starFull = starFull;
            return this;
        }

        //    半星资源文件值
        public Builder starHalf(int starHalf) {
            this.starHalf = starHalf;
            return this;
        }

        //    是否可点击boolean值
        public Builder clickable(boolean clickable) {
            this.clickable = clickable;
            return this;
        }

        //    当前进度float值--星数
        public Builder initSelectValue(float initSelectValue) {
            this.initSelectValue = initSelectValue;
            return this;
        }

        //    每次进度方式的值，整星还是半星
        public Builder stepWay(int stepWay) {
            this.stepWay = stepWay;
            return this;
        }

        //    每颗星的分值
        public Builder valueOfEveryStar(float valueOfEveryStar) {
            this.valueOfEveryStar = valueOfEveryStar;
            return this;
        }

        public void build() {
            Log.d("Builder", this.toString());
            invalidateView(context, this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "context=" + context +
                    ", starImageSize=" + starImageSize +
                    ", starMargin=" + starMargin +
                    ", starCount=" + starCount +
                    ", starEmpty=" + starEmpty +
                    ", starFull=" + starFull +
                    ", starHalf=" + starHalf +
                    ", clickable=" + clickable +
                    ", initSelectValue=" + initSelectValue +
                    ", stepWay=" + stepWay +
                    ", valueOfEveryStar=" + valueOfEveryStar +
                    '}';
        }
    }


    private void initData(Context context) {
        for (int i = 0; i < starCount; i++) {
            ImageView imageView = new ImageView(context);
            LayoutParams layoutParams = new LayoutParams(starImageSize, starImageSize);
            if (i != 0)
                layoutParams.setMargins(starMargin, 0, 0, 0);
            imageView.setLayoutParams(layoutParams);
            StarRecord starRecord = new StarRecord();
            if (stepWay == 1) {//满星方式
                if (i < initSelectValue) {
                    imageView.setImageResource(starFull);
                    starRecord.setStarStyle(FULL);
                } else {
                    imageView.setImageResource(starEmpty);
                    starRecord.setStarStyle(EMPTY);
                }
            } else if (stepWay == 0) {//半星方式
                if (i < initSelectValue - 1) {
                    imageView.setImageResource(starFull);
                    starRecord.setStarStyle(FULL);
                } else if (initSelectValue > i && i > initSelectValue - 1) {
                    imageView.setImageResource(starHalf);
                    starRecord.setStarStyle(HALF);
                } else {
                    imageView.setImageResource(starEmpty);
                    starRecord.setStarStyle(EMPTY);
                }
            }
            if (initSelectValue > 1) {
                showingStarPosition = (float) (initSelectValue * starImageSize + (Math.ceil(initSelectValue) - 1) * starMargin);
            } else {
                showingStarPosition = initSelectValue * starImageSize;
            }
            addView(imageView);
            starRecord.setImg(imageView);
            starImageViewList.add(starRecord);
        }
        setOnListener();
        invalidate();
    }

    /**
     * 设置点击、滑动监听事件
     */
    private void setOnListener() {
        setOnClickListener();
        setOnTouchListener();
    }

    public float showingStarPosition = 0;//记录星星到空间最左端的距离（从0开始；-1表示全部Empty）

    float touchDownX = -1;
    boolean mScrolling;

    /**
     * 是否传递到子view
     * true  不传递
     * false 传递
     * 一次触摸屏幕中，如果拦截过则不会再次进入onInterceptTouchEvent
     * 触摸屏幕中，如果在ACTION_DOWN时返回true，则不会再有ACTION_MOVE和ACTION_UP拦截
     * 如果ACTION_DOWN返回false,ACTION_MOVE中返回true，则不会有ACTION_UP拦截
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //如果ACTION_DOWN未被拦截，则有可能被子view消费，一旦消费后，
                //则父容器中OnTouchEvent中就不会接受到ACTION_DOWN事件
                System.out.println("onInterceptTouchEvent ACTION_DOWN");
                touchDownX = event.getX();

                mScrolling = false;

                velocityTracker = VelocityTracker.obtain();

                velocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("onInterceptTouchEvent ACTION_MOVE");

                if (Math.abs(touchDownX - event.getX()) >= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    mScrolling = true;
                    System.out.println("onInterceptTouchEvent ACTION_MOVE    "  +true);
                } else {
                    mScrolling = false;
                    System.out.println("onInterceptTouchEvent ACTION_MOVE    "  +false);
                }

                break;
            case MotionEvent.ACTION_UP:
                //如果ACTION_MOVE判断是点击就会进入ACTION_UP，是滚动则不会进入
                System.out.println("onInterceptTouchEvent ACTION_UP");

                //返回false以便子控件接收ACTION_UP事件
                mScrolling = false;

                break;
        }

        return mScrolling;
    }

    VelocityTracker velocityTracker = VelocityTracker.obtain();


    private void setOnTouchListener() {
        View rootView = this.getRootView();
        rootView.setLayoutParams(new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        rootView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("setOnTouchListener","触摸   "+"x:"+event.getX()+"   y:"+event.getY());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        showingStarPosition = event.getX();
                        double num = Math.floor(showingStarPosition / (starMargin + starImageSize));
                        float yuShu = showingStarPosition % (starMargin + starImageSize);
                        if (showingStarPosition <= 0) {//rootview左侧
                            for (int i = 0; i < starImageViewList.size(); i++) {
                                starImageViewList.get(i).getImg().setImageResource(starEmpty);
                                starImageViewList.get(i).setStarStyle(EMPTY);
                            }
                        } else if (showingStarPosition > 0 && showingStarPosition > (starImageViewList.size() * (starImageSize + starMargin) - starMargin)) {//rootview右侧
                        } else {//rootview中间
                            if (stepWay == 1) {//满星方式
                                if (yuShu < starImageSize) {
                                    for (int i = 0; i < starImageViewList.size(); i++) {
                                        if (i <= num) {
                                            starImageViewList.get(i).getImg().setImageResource(starFull);
                                            starImageViewList.get(i).setStarStyle(FULL);
                                        } else {
                                            starImageViewList.get(i).getImg().setImageResource(starEmpty);
                                            starImageViewList.get(i).setStarStyle(EMPTY);
                                        }
                                    }
                                }
                            } else if (stepWay == 0) {//半星方式
                                if (starImageSize / 2 < yuShu && yuShu < starImageSize) {//满星
                                    for (int i = 0; i < starImageViewList.size(); i++) {
                                        if (i <= num) {
                                            starImageViewList.get(i).getImg().setImageResource(starFull);
                                            starImageViewList.get(i).setStarStyle(FULL);
                                        } else {
                                            starImageViewList.get(i).getImg().setImageResource(starEmpty);
                                            starImageViewList.get(i).setStarStyle(EMPTY);
                                        }
                                    }
                                } else if (yuShu < starImageSize / 2) {
                                    for (int i = 0; i < starImageViewList.size(); i++) {//半星
                                        if (i < num) {
                                            starImageViewList.get(i).getImg().setImageResource(starFull);
                                            starImageViewList.get(i).setStarStyle(FULL);
                                        } else if (i == num) {
                                            starImageViewList.get(i).getImg().setImageResource(starHalf);
                                            starImageViewList.get(i).setStarStyle(HALF);
                                        } else {
                                            starImageViewList.get(i).getImg().setImageResource(starEmpty);
                                            starImageViewList.get(i).setStarStyle(EMPTY);
                                        }
                                    }
                                }
                            }
                        }

                        break;
                }
                return true;
            }
        });
    }

    private void setOnClickListener() {
        if (clickable)
            for (int i = 0; i < starImageViewList.size(); i++) {
                final int m = i;
                starImageViewList.get(i).getImg().setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int j = 0; j < starImageViewList.size(); j++) {
                            if (j < m) {//选择该star前的star变化
                                starImageViewList.get(j).getImg().setImageResource(starFull);
                                starImageViewList.get(j).setStarStyle(FULL);
                            } else if (j == m) {//选择该star的star变化
                                if (stepWay == 1) {//满星方式
                                    if (starImageViewList.get(j).getStarStyle() == EMPTY) {
                                        starImageViewList.get(j).getImg().setImageResource(starFull);
                                        starImageViewList.get(j).setStarStyle(FULL);
                                    } else if (starImageViewList.get(j).getStarStyle() == FULL) {
                                        if (m < starImageViewList.size() - 1 && starImageViewList.size() > 1 && starImageViewList.get(j + 1).getStarStyle() == FULL)//去除多星变少星时，点击的该星变黑                                            ;
                                            ;
                                        else {
                                            starImageViewList.get(j).getImg().setImageResource(starEmpty);
                                            starImageViewList.get(j).setStarStyle(EMPTY);
                                        }
                                    }
                                } else if (stepWay == 0) {//半星方式
                                    if (starImageViewList.get(j).getStarStyle() == FULL) {
                                        if (m < starImageViewList.size() - 1 && starImageViewList.size() > 1 && starImageViewList.get(j + 1).getStarStyle() == FULL)//去除问题：多星变少星时，点击的该星变黑                                            ;
                                            ;
                                        else {
                                            starImageViewList.get(j).getImg().setImageResource(starHalf);
                                            starImageViewList.get(j).setStarStyle(HALF);
                                        }
                                    } else if (starImageViewList.get(j).getStarStyle() == HALF) {
                                        starImageViewList.get(j).getImg().setImageResource(starEmpty);
                                        starImageViewList.get(j).setStarStyle(EMPTY);
                                    } else if (starImageViewList.get(j).getStarStyle() == EMPTY) {
                                        starImageViewList.get(j).getImg().setImageResource(starFull);
                                        starImageViewList.get(j).setStarStyle(FULL);
                                    }
                                }
                            } else {//选择该star后的star变化
                                starImageViewList.get(j).getImg().setImageResource(starEmpty);
                                starImageViewList.get(j).setStarStyle(EMPTY);
                            }
                        }
                    }
                });
            }
    }

    /**
     * 获取当前分值
     *
     * @return
     */
    public float getEvaluationScore() {
        float score = 0;
        for (int i = 0; i < starImageViewList.size(); i++) {
            switch (starImageViewList.get(i).getStarStyle()) {
                case FULL:
                    score += valueOfEveryStar;
                    break;
                case HALF:
                    score += valueOfEveryStar / 2;
                    break;
            }
        }
        return score;
    }

    public static final int FULL = 0;
    public static final int HALF = 1;
    public static final int EMPTY = 2;

    class StarRecord {
        ImageView img;
        int starStyle;


        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public int getStarStyle() {
            return starStyle;
        }

        public void setStarStyle(int starStyle) {
            this.starStyle = starStyle;
        }
    }

    public static float dp2px(float dpVal, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dpVal * scale);
    }
}
