/*
Name: Afiq Hanif
Matrix Number:S62993
Date: 10/10/2023
*/

import 'package:flutter/material.dart';

class Answer extends StatelessWidget{
  
  final Function selectHandler;
  final String answerText;
  Answer( this.selectHandler, this.answerText);

  @override
  Widget build(BuildContext context){
    return Container(
      width: double.infinity,
      child: ElevatedButton(
        style: ElevatedButton.styleFrom(
          backgroundColor: Colors.blue,
          foregroundColor: Colors.white,
        ),
        child: Text(answerText),
        onPressed: ()=>selectHandler(),
      ),
    );
  }
}