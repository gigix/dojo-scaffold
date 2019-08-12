package org.codingdojo.kata.args;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void should_create_args_out_of_text() {
        // 1. 用schema的描述字符串创建一个Schema对象
        // 这一步，我们在前一个练习中已经做过了
        Schema schema = new Schema("l:boolean p:integer d:string");

        // 2. 用"要解析的整个字符串"创建一个叫做Args的对象
        //  思考：Args对象的构造函数，应该接受哪些参数？
        Args args = new Args(schema, "-l true", "-p 8080", "-d /usr/log");

        // 3. Args对象的size方法可以告诉我们，其中包含几个参数（arg）
        //  写一个测试，验证size方法
        assertThat(args.size(), is(3));

        // 4. 思考：Args对象包含的"3个东西"应该是什么东西？
        //  是否需要创建一个新的类？
        //  这个新的类需要哪些数据？
        //  这个新的类应该有哪些行为？

        // 5. 从Args对象中取出"l"参数的值
        //  思考："取出参数值"的方法名应该叫什么？返回值应该是什么类型？
        assertThat(args.valueOf("l"), is(true));

        // 6. 从Args对象中取出"p"参数的值
        assertThat(args.valueOf("p"), is(8080));

        // 7. 回头看看代码，有没有可以改进的地方？
        //  尤其注意：是否有违反迪米特法则的代码？
    }

    // 8. 增加一个异常处理的逻辑
    //  如果传入的参数在schema中没有定义，该怎么办？

    // 9. 再增加一个异常处理的逻辑
    //  如果尝试提取的参数不存在，该怎么办？
}
