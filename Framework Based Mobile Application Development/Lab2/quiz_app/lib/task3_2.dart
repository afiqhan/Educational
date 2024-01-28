/*
Name: Afiq Hanif
Matrix Number:S62993
Date: 10/10/2023
*/
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}
void answerQuestion(){
  print('Answer chosen ..!');
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('My Quiz App'),
        ),
        body:  Column(
          children: [
            Text('The questions'),
            ElevatedButton(onPressed: answerQuestion, child: Text('Answer 1')),
            ElevatedButton(onPressed:()=> print('Answer 2') , child: Text('Answer 2')),
            ElevatedButton(onPressed: ()=> print('Answer 3'), child: Text('Answer 3')),
          ],
        ) ,
      ),
    );
  }
}