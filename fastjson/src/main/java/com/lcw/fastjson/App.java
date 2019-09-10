package com.lcw.fastjson;

import java.util.ArrayList;
import com.alibaba.fastjson.JSON;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static String SPACE = "   ";
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        module m = new module();
        m.setModule_id(100);
        m.setP_id(-1);
        m.module_list = new ArrayList<module>();
     
        
        module m1 = new module();
        m1.setModule_id(101);
        m1.setP_id(100);
        m1.permission_list = new ArrayList<permission>();
        permission p1 = new permission();
        p1.setModule_id(101);
        p1.setName("增加");
        p1.setPermission_id(222);
        permission p2 = new permission();
        p2.setModule_id(101);
        p2.setName("增加");
        p2.setPermission_id(222);
        m1.permission_list.add(p1);
        m1.permission_list.add(p2);
        
        module m2 = new module();
        m2.setModule_id(102);
        m2.setP_id(100);
        
        m.module_list.add(m1);
        m.module_list.add(m2);
        
        
        String s = JSON.toJSONString(m);
        System.out.println(formatJson(s));        
        
        
    }
    
    
    public static String formatJson(String json)
    {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;
        //遍历输入字符串。
        for (int i = 0; i < length; i++)
        {
            //1、获取当前字符。
            key = json.charAt(i);

            //2、如果当前字符是前方括号、前花括号做如下处理：
            if((key == '[') || (key == '{') )
            {
                //（1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if((i - 1 > 0) && (json.charAt(i - 1) == ':'))
                {
                    result.append('\n');
                    result.append(indent(number));
                }

                //（2）打印：当前字符。
                result.append(key);

                //（3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                //（4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                //（5）进行下一次循环。
                continue;
            }

            //3、如果当前字符是后方括号、后花括号做如下处理：
            if((key == ']') || (key == '}') )
            {
                //（1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                //（2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                //（3）打印：当前字符。
                result.append(key);

                //（4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if(((i + 1) < length) && (json.charAt(i + 1) != ','))
                {
                    result.append('\n');
                }

                //（5）继续下一次循环。
                continue;
            }

            //4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if((key == ','))
            {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            //5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }

    /**
     * 返回指定次数的缩进字符串。每一次缩进三个空格，即SPACE。
     * 
     * @param number 缩进次数。
     * @return 指定缩进次数的字符串。
     */
    private static String indent(int number)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++)
        {
            result.append(SPACE);
        }
        return result.toString();
    }
    
}
