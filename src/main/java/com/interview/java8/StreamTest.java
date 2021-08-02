package com.java8;

import com.alibaba.fastjson.JSON;
import com.model.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {


    List<Student> students = new ArrayList<Student>() {
        {
            add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
            add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
            add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
            add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
            add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
            add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
            add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
            add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
            add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
            add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
        }
    };

    List<Integer> nums = new ArrayList<Integer>() {
        {
            add(2);
            add(1);
            add(3);
            add(4);
            add(2);
            add(3);
            add(1);
            add(3);
            add(4);
            add(2);
        }
    };

    String[] strs = {"java8", "is", "easy", "to", "use"};


    @Test
    public void streamTest(){
//        List<Student> collect = students.stream().filter(e -> e.getGrade() == 4).collect(Collectors.toList()); // 筛选
//        List<Integer> collect = nums.stream().filter(e -> e % 2 == 0).distinct().collect(Collectors.toList()); // 去重
//        List<Student> collect = students.stream().filter(student -> "土木工程".equals(student.getMajor())).limit(2).collect(Collectors.toList()); // 取前几个
//        List<Student> collect = students.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted((s1,s2) -> s2.getAge() - s1.getAge()).collect(Collectors.toList()); // 从大到小
//        List<Student> collect = students.stream().filter(student -> "土木工程".equals(student.getMajor())).sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList()); // 从小到大
//        List<Student> collect = students.stream().filter(student -> "土木工程".equals(student.getMajor())).skip(2).collect(Collectors.toList()); // 跳过前几个
//        List<String> collect = students.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getName).collect(Collectors.toList()); // 映射属性，返回数组字符串
//        int sum = students.stream().filter(student -> "土木工程".equals(student.getMajor())).mapToInt(Student::getAge).average().sum();// 映射到Integer，返回Integer
//        List<String[]> collect = Arrays.stream(strs).map(s -> s.split("")).collect(Collectors.toList());
//        List<String> collect = Arrays.stream(strs).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()); // flagMap将Stream<String[]> 转换成 Stream<String>
//        boolean b = students.stream().allMatch(student -> student.getAge() > 18); // 判断是否每条记录都满足条件
//        boolean b = students.stream().anyMatch(student -> "土木工程".equals(student.getMajor())); // 判断是否有一条或以上记录满足条件
//        boolean b = students.stream().noneMatch(student -> student.getAge() == 21); // 判断是否没有记录满足条件
//        Optional<Student> first = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findFirst(); // 获取第一个
//        Optional<Student> any = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findAny(); // 获取任意一个,但是和first结果一样

//        归约
//        int sum = students.stream().filter(student -> "土木工程".equals(student.getMajor())).mapToInt(Student::getAge).sum(); //和上面一样
//        Integer reduce = students.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getAge).reduce(0, (a, b) -> a + b); // 归约操作
//        Integer reduce = students.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getAge).reduce(0, Integer::sum); // 上面的简化操作
//        Optional<Integer> reduce = students.stream().filter(student -> "土木工程".equals(student.getMajor())).map(Student::getAge).reduce(Integer::sum);// 去掉初始值，返回Optional

//        收集
//        Long collect = students.stream().collect(Collectors.counting()); // 获取总数
//        Long collect = students.stream().count(); // 上面的简化
//        Optional<Student> collect = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge())); // 最大
//        Optional<Student> collect = students.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getAge))); // 最大
//        Optional<Student> collect = students.stream().max(Comparator.comparingInt(Student::getAge)); // 最大
//        Optional<Student> collect = students.stream().collect(Collectors.minBy((s1, s2) -> s1.getAge() - s2.getAge())); // 最小
//        Optional<Student> collect = students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getAge))); // 最小
//        Optional<Student> collect = students.stream().min(Comparator.comparingInt(Student::getAge)); // 最小
//        Integer collect = students.stream().collect(Collectors.summingInt(Student::getAge)); // 求和
//        Integer collect = students.stream().mapToInt(Student::getAge).sum(); // 简化
//        Double collect = students.stream().collect(Collectors.averagingDouble(Student::getAge)); // 平均值
//        Double collect = students.stream().collect(Collectors.averagingInt(Student::getAge)); // 平均值
//        IntSummaryStatistics collect = students.stream().collect(Collectors.summarizingInt(Student::getAge)); // 一次性得到元素个数、总和、均值、最大值、最小值
//        String collect = students.stream().map(Student::getName).collect(Collectors.joining()); // 字符串拼接
//        String collect = students.stream().map(Student::getName).collect(Collectors.joining(",")); // 添加分隔符拼接
//        这里如果不填写第二个参数 默认为Collectors.toList()
//        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getSchool)); // 按学校分组
//        Map<String, Map<String, List<Student>>> collect = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.groupingBy(Student::getMajor))); // 一级学校，二级专业分组
//        Map<String, Long> collect = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.counting())); // 统计学校的人数
//        Map<String, Map<String, Long>> collect = students.stream().collect(Collectors.groupingBy(Student::getSchool, Collectors.groupingBy(Student::getMajor, Collectors.counting()))); // 每个学校每个专业的人数
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool()))); // 分区，满足条件为true区，不满足为false区


        System.out.println(JSON.toJSONString(collect));
    }

}
