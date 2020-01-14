int redLed = 12;
int greenLed = 11;
//int buzzer = 10;
int smokeid = A0;
// Your threshold value
int sensorThres = 555;

void setup() {
  pinMode(redLed, OUTPUT);
  pinMode(greenLed, OUTPUT);
  //pinMode(buzzer, OUTPUT);
  pinMode(smokeid, INPUT);
  Serial.begin(9600);
}

void loop() {
  int analogSensor = analogRead(smokeid);

  Serial.print("Pin A0: ");
  Serial.println(analogSensor);
  // Checks if it has reached the threshold value
  if (analogSensor > sensorThres)
  {
    digitalWrite(redLed, HIGH);
    digitalWrite(greenLed, LOW);
    //tone(buzzer, 1000, 200);
  }
  else
  {
    digitalWrite(redLed, LOW);
    digitalWrite(greenLed, HIGH);
  //  noTone(buzzer);
  }
  delay(500);
}
