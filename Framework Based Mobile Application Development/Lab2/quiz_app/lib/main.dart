/*
Name: Afiq Hanif
Matrix Number:S62993
Date: 10/10/2023
*/

import 'package:flutter/material.dart';
import 'question.dart';
import 'answer.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  @override
  const MyApp({super.key});
  State<StatefulWidget> createState() {
    return MyAppState();
    throw UnimplementedError();
  }
}

class MyAppState extends State<MyApp> {
  var _questionIndex = 0;

  var question =[
    {
      'questionText':'what \'s your favourite colour?',
    'answers': ['Black', 'Red','Green', 'Blue'],
    },
    {
      'questionText':'what \'s your favourite animal?',
    'answers': ['Cat', 'Tiger','Lion', 'Rabbit'],
    },
    {
      'questionText':'what \'s your favourite instructor?',
    'answers': ['Alan', 'David','Richard', 'Steven'],
    }
  ];

void _answerQuestion() {
  
  setState(() {
   // _questionIndex = (_questionIndex < question.length - 1) ? _questionIndex + 1 : 0;
   if(_questionIndex < question.length){
    _questionIndex = _questionIndex +1;
   }else{
    print(_questionIndex);
    print('we finish the quiz');
   }
  });
}


  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('My Quiz App'),
        ),
        body: _questionIndex < question.length ?
        Column(
          children: [
            Question(question[_questionIndex]['questionText'] as String,),
            ...(question[_questionIndex]['answers'] as List<String>).map((answer){
              return Answer(_answerQuestion, answer);
            }).toList(),
            // Answer(_answerQuestion, 'Answer 1'),
            // Answer(_answerQuestion, 'Answer 2'),
            // Answer(_answerQuestion, 'Answer 3'),
          ],
        )
        : const Text('No question to Display'),
      ),
    );
  }
}
// class MyColumnWidget extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     // Create a list of widgets using a for loop
//     List<Widget> widgetList = [];
//     for (int i = 1; i <= 2; i++) {
//       widgetList.add(
//         ListTile(
//           title: Text('Answer ${i+1}'),
//         ),
//       );
//     }

//     // Create a Column widget and use the spread operator to add the widgets
//     return Column(
//       children: [
//         ...widgetList,
//       ],
//     );
//   }
// }