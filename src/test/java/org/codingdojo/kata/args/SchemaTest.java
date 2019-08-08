package org.codingdojo.kata.args;

import org.junit.Test;

public class SchemaTest {
    @Test
    public void should_create_schema_out_of_text() {
        // 1. 用schema的描述字符串创建一个Schema对象
        //  如果实在没想法，可以考虑这样写：
        //  Schema schema = new Schema("l:boolean p:integer d:string");
        //  记住：只写最少的、能让测试通过的代码


        // 2. Schema的size方法会告诉我们，这个Schema对象包含几个参数规格
        //  写一个断言验证size方法
        //  写最少的代码让测试通过


        // 3. 思考一下，如果要从Schema中取得某个参数（例如参数"l"）的类型（"boolean"）
        //  Schema内部应该以什么形式保存数据？
        //  调整现有的代码，以合适的形式在Schema内部保存数据
        //  注意不要过度设计，把数据保存好就行了


        // 4. 写一个断言，验证从Schema取出参数类型的逻辑正确
        //  只验证正确的情况，暂时不考虑错误（例如：参数名称不存在）的情况
        //  写最少的代码让测试通过
        //  注意观察：这一步是不是迈得特别大？可以如何缩小步伐？
    }


    // 5. 再写一个测试，验证从Schema中取出参数类型时，参数名称不存在的情况
    // 例如：
    //  Schema schema = new Schema("l:boolean p:integer d:string");
    //  尝试从这个schema中取出参数"w"的类型
    // 请思考：
    //  这个测试应该叫什么名字？
    //  当尝试取出不存在的参数名称时，程序应该有什么行为？



    // 6. 再写一个测试，验证创建Schema时传入多个同名参数的情况
    // 例如：
    //  Schema schema = new Schema("l:boolean p:integer d:string p:string");
    // 请思考：
    //  这个测试应该叫什么名字？
    //  当传入多个同名参数的时候，程序应该有什么行为？



    // 7. 想一想，接下来可以如何使用Schema对象？
}
