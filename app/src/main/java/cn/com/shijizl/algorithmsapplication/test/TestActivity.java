package cn.com.shijizl.algorithmsapplication.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cn.com.shijizl.algorithmsapplication.R;

public class TestActivity extends AppCompatActivity {
    private int[] array = new int[]{5, 3, 9, 1, 4, 7, 8, 2, 0, 6};
    private int[] array1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private int[] array2 = new int[]{3, 4, 5, 6, 8, 9, 0, 0, 0, 0};
    private int[] array3 = new int[]{1, 2, 7};

    private int[] array4 = new int[]{3, 4, 5, 6, 8, 9, 1, 7, 2, 0};

    public static void start(Context context) {
        context.startActivity(new Intent(context, TestActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        findViewById(R.id.bt_test_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TestUtils.print("排序前..", array2);

//                TestUtils.bobble(array);
//                TestUtils.funSelectionSort(array);
//                TestUtils.funDInsertSort(array);
//                TestUtils.shell(array);
//                TestUtils.funMergeSort(array);
//                TestUtils.funQuickSort(array, 0, array.length);
//                TestUtils.funFib(10);
//                TestUtils.funSwapTwo(4, 5);
//                TestUtils.mergyArray(array2, 6, array3, 3);

//                TestUtils.Node<Integer> node = TestUtils.createNode(3);
//                TestUtils.printNode(node);
//                TestUtils.Node<Integer> node1 = TestUtils.createNode(4);
//                TestUtils.printNode(node1);
//                TestUtils.Node<Integer> mergeNode = TestUtils.mergeNode(node, node1);
//                TestUtils.printNode(mergeNode);

//                TestUtils.Node<Integer> node = TestUtils.createNode(3);
//                TestUtils.printNode(node);
//                TestUtils.reversePrint(node);
//                TestUtils.Node<Integer> node1 = TestUtils.findNode(node, 1);
//                TestUtils.printNode(node1);

//                int count = TestUtils.findCount(7);

                TestUtils.recordArray(array4);

                TestUtils.print("排序后....", array4);
            }
        });
    }
}
