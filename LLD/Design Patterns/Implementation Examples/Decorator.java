/*

Source:
https://refactoring.guru/design-patterns/decorator + chatGPT

We added one email notifier last year. Now we send notifications via slack,email,sms etc through multiple modes. 
If we try to use Combination of These Modes, Then We End Up Many Creating Classes By Extending It!

So, we use decorator pattern here!

*/

// Step 1: Define the Notifier interface
interface Notifier {
    void send(String message);
}

// Step 2: Create a Basic Notifier implementation
class BasicNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }
}

// Step 3: Create abstract Decorator class
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Step 4: Create Singleton Decorators
class SMSNotifier extends NotifierDecorator {
    // Thread-safe Singleton implementation for SMSNotifier
    private static SMSNotifier instance;

    private SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    public static synchronized SMSNotifier getInstance(Notifier notifier) {
        if (instance == null) {
            instance = new SMSNotifier(notifier);
        }
        return instance;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

class FacebookNotifier extends NotifierDecorator {
    // Thread-safe Singleton implementation for FacebookNotifier
    private static FacebookNotifier instance;

    private FacebookNotifier(Notifier notifier) {
        super(notifier);
    }

    public static synchronized FacebookNotifier getInstance(Notifier notifier) {
        if (instance == null) {
            instance = new FacebookNotifier(notifier);
        }
        return instance;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Facebook notification: " + message);
    }
}

class SlackNotifier extends NotifierDecorator {
    // Thread-safe Singleton implementation for SlackNotifier
    private static SlackNotifier instance;

    private SlackNotifier(Notifier notifier) {
        super(notifier);
    }

    public static synchronized SlackNotifier getInstance(Notifier notifier) {
        if (instance == null) {
            instance = new SlackNotifier(notifier);
        }
        return instance;
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

// Step 5: Test the Singleton Decorator Pattern
class Decorator {
    public static void main(String[] args) {
        // Basic notification
        Notifier basicNotifier = new BasicNotifier();

        // Get Singleton Instances of Notifiers
        SMSNotifier smsNotifier = SMSNotifier.getInstance(basicNotifier);
        FacebookNotifier facebookNotifier = FacebookNotifier.getInstance(basicNotifier);
        SlackNotifier slackNotifier = SlackNotifier.getInstance(basicNotifier);

        System.out.println("\nSending SMS Notification:");
        smsNotifier.send("Hello!");

        System.out.println("\nSending Facebook and Slack Notifications:");
        Notifier combinedNotifier = SlackNotifier.getInstance(
            FacebookNotifier.getInstance(SMSNotifier.getInstance(basicNotifier))
        );
        combinedNotifier.send("Hello!");
    }
}



//Example 2 : iluwatar java design patterns decorator example!
