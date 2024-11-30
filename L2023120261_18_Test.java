package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 *
 * 测试用例设计的总体原则:
 * 1. 等价类划分: 将输入数据划分为几个等价类，选择有代表性的值作为测试用例。
 * 2. 边界值分析: 考虑到数组的边界情况，如空数组、单元素数组、最大最小可能的数组长度。
 * 3. 错误推测法: 根据经验预测容易出错的情况，如数组中有0的情况，以及所有元素都相同的情况。
 */
public class L2023120261_18_Test {
    private Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    /**
     * 测试目的: 验证常规情况下算法是否能正确计算出除了自身以外数组的乘积。
     * 测试策略: 使用等价类划分，选取一组正整数进行测试。
     * 测试用例: 输入一个包含不同正整数的数组 {1, 2, 3, 4}。
     */
    @Test
    public void testProductExceptSelfNormalCase() {
        int[] input = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "常规情况下的输出不正确");
    }

    /**
     * 测试目的: 检查当输入数组包含零时，函数是否能正确处理并返回预期结果。
     * 测试策略: 使用边界值分析，考虑至少存在一个0的情况。
     * 测试用例: 输入一个包含至少一个0的数组 {-1, 1, 0, -3, 3}。
     */
    @Test
    public void testProductExceptSelfWithZero() {
        int[] input = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "包含零的情况下的输出不正确");
    }

    /**
     * 测试目的: 确认单元素数组的处理是否符合预期，即返回 [1]。
     * 测试策略: 使用边界值分析，考虑最短的有效数组。
     * 测试用例: 输入一个只包含一个非零元素的数组 {5}。
     */
    @Test
    public void testProductExceptSelfSingleElement() {
        int[] input = {5};
        int[] expected = {1}; // 注意：这里的预期结果取决于题目要求
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "单个元素数组的输出不正确");
    }

    /**
     * 测试目的: 测试空数组作为输入的情况，应返回空数组。
     * 测试策略: 使用边界值分析，考虑最极端的数组长度。
     * 测试用例: 输入一个空数组 {}。
     */
    @Test
    public void testProductExceptSelfEmptyArray() {
        int[] input = {};
        int[] expected = {};
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "空数组输入的输出不正确");
    }

    /**
     * 测试目的: 检查所有元素相同的数组，验证是否能正确计算出除了自身以外数组的乘积。
     * 测试策略: 使用等价类划分，考虑所有元素相等但非零的情况。
     * 测试用例: 输入一个所有元素都相同的数组 {2, 2, 2, 2}。
     */
    @Test
    public void testProductExceptSelfAllElementsSame() {
        int[] input = {2, 2, 2, 2};
        int[] expected = {8, 8, 8, 8};
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "所有元素相同情况下的输出不正确");
    }

    /**
     * 测试目的: 检查当输入数组包含负数时，函数是否能正确处理并返回预期结果。
     * 测试策略: 使用等价类划分，考虑含有负数的数组。
     * 测试用例: 输入一个包含负数的数组 {-1, 2, -3, 4}。
     */
    @Test
    public void testProductExceptSelfWithNegativeNumbers() {
        int[] input = {-1, 2, -3, 4};
        int[] expected = {-24, 12, -8, 6};  // 负数乘积的正确结果
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "包含负数的情况下的输出不正确");
    }

    /**
     * 测试目的: 检查当输入数组中包含多个零时，函数是否能正确处理并返回预期结果。
     * 测试策略: 使用错误推测法，考虑存在多个0的情况。
     * 测试用例: 输入一个包含多个零的数组 {0, 2, 0, 4}。
     */
    @Test
    public void testProductExceptSelfWithMultipleZeros() {
        int[] input = {0, 2, 0, 4};
        int[] expected = {0, 0, 0, 0};  // 任何包含0的乘积结果应为0
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "多个零的情况下的输出不正确");
    }

    /**
     * 测试目的: 验证极大数值的情况下算法是否能正确计算出除了自身以外数组的乘积。
     * 测试策略: 使用边界值分析，考虑数值达到整型最大值的情况。
     * 测试用例: 输入一个包含极大数值的数组 {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}。
     */
    @Test
    public void testProductExceptSelfWithLargeNumbers() {
        int[] input = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        // 注意: 这里可能会导致溢出，需要根据实际情况调整测试用例或方法实现
        int[] expected = {Integer.MAX_VALUE * Integer.MAX_VALUE, Integer.MAX_VALUE * Integer.MAX_VALUE, Integer.MAX_VALUE * Integer.MAX_VALUE};
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "极大数值的情况下的输出不正确");
    }

    /**
     * 测试目的: 测试更大规模的数组以确保算法在较大输入下依然有效。
     * 测试策略: 使用边界值分析，考虑较长的数组长度。
     * 测试用例: 输入一个包含100个元素的数组，所有元素均为1。
     */
    @Test
    public void testProductExceptSelfLargeArray() {
        int[] input = new int[100];
        for (int i = 0; i < 100; i++) {
            input[i] = 1;
        }
        int[] expected = new int[100];
        for (int i = 0; i < 100; i++) {
            expected[i] = 1;
        }
        int[] actual = solution.productExceptSelf(input);
        assertArrayEquals(expected, actual, "大规模数组的输出不正确");
    }
}