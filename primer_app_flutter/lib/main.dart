import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Mi Aplicación Flutter',
      home: const MyHomePage(title: 'Flutter app'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Número de veces que se presionó el botón:',
            ),
            Text(
              '$_counter',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold, color: Colors.blue),
            ),
            // Agregar un widget de diseño
            Image.asset(
              'assets/flutter_logo.png',
              width: 150,
              height: 150,
            ),
          ],
        ),
      ),
      // Agregar un widget estructural (por ejemplo, un Container)
      floatingActionButton: Container(
        padding: EdgeInsets.all(16.0),
        child: ElevatedButton(
          onPressed: _incrementCounter,
          style: ElevatedButton.styleFrom(
            primary: Colors.blue,
          ),
          child: Icon(Icons.add),
        ),
      ),
    );
  }
}

