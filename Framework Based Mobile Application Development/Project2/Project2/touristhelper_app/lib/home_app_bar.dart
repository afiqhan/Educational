import 'package:flutter/material.dart';
import 'package:touristhelper_app/screens/welcome_screen.dart';

class HomeAppBar extends StatefulWidget {
  @override
  _HomeAppBarState createState() => _HomeAppBarState();
}

class _HomeAppBarState extends State<HomeAppBar> {
  TextEditingController _searchCotrfinaoller = TextEditingController();
  List<String> allContainerNames = ["Kuala Lumpur", "Terengganu", "Sarawak", "Kedah", "Johor", "Sabah", "Melaka", "Langkawi", "Pahang"];
  List<String> displayedContainerNames = [];

  @override
  void initState() {
    super.initState();
    displayedContainerNames = List.from(allContainerNames);
  }

  void _searchContainers(String query) {
    setState(() {
      displayedContainerNames = allContainerNames
          .where((name) => name.toLowerCase().contains(query.toLowerCase()))
          .toList();
    });
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(20),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
        InkWell(
  onTap: () {
    // Show an alert dialog to confirm logout
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text("Log Out"),
          content: Text("Are you sure you want to logout?"),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.pop(context); // Close the alert dialog
              },
              child: Text("Cancel"),
            ),
            TextButton(
              onPressed: () {
                // Implement logout functionality and navigate to the login page
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => WelcomeScreen(), // Replace with the actual route for the welcome screen
                  ),
                );
              },
              child: Text("Logout"),
            ),
          ],
        );
      },
    );
  },
  child: Container(
    clipBehavior: Clip.hardEdge,
    padding: EdgeInsets.all(10),
    decoration: BoxDecoration(
      color: Colors.white,
      boxShadow: [
        BoxShadow(
          color: Colors.black,
          blurRadius: 6,
        ),
      ],
      borderRadius: BorderRadius.circular(10),
    ),
    child: Icon(
      Icons.logout_rounded,
      size: 28,
    ),
  ),
),

          Row(
            children: [
              Icon(
                Icons.location_on,
                color: Color(0xFFF65959),
              ),
              Text(
                "Malaysia",
                style: TextStyle(
                  fontSize: 18,
                  fontWeight: FontWeight.w500,
                ),
              )
            ],
          ),
          InkWell(
            onTap: () {
              // Show a search dialog or navigate to a search screen
              showSearch(
                context: context,
                delegate: CustomSearchDelegate(allContainerNames),
              );
            },
            child: Container(
              padding: EdgeInsets.all(10),
              decoration: BoxDecoration(
                color: Colors.white,
                boxShadow: [
                  BoxShadow(
                    color: Colors.black,
                    blurRadius: 6,
                  )
                ],
                borderRadius: BorderRadius.circular(15),
              ),
              child: Icon(
                Icons.search,
                size: 28,
              ),
            ),
          ),
        ],
      ),
    );
  }
}

// Rest of your code...


class CustomSearchDelegate extends SearchDelegate<String> {
  final List<String> containerNames;

  CustomSearchDelegate(this.containerNames);

  @override
  List<Widget> buildActions(BuildContext context) {
    return [
      IconButton(
        icon: Icon(Icons.clear),
        onPressed: () {
          query = '';
        },
      ),
    ];
  }

  @override
  Widget buildLeading(BuildContext context) {
    return IconButton(
      icon: Icon(Icons.arrow_back),
      onPressed: () {
        close(context, '');
      },
    );
  }

  @override
  Widget buildResults(BuildContext context) {
    return _buildSearchResults();
  }

  @override
  Widget buildSuggestions(BuildContext context) {
    return _buildSearchResults();
  }

  Widget _buildSearchResults() {
    final List<String> results = containerNames
        .where((name) => name.toLowerCase().contains(query.toLowerCase()))
        .toList();

    return ListView.builder(
      itemCount: results.length,
      itemBuilder: (context, index) {
        return ListTile(
          title: Text(results[index]),
          // You can add onTap functionality here if needed
        );
      },
    );
  }
}
