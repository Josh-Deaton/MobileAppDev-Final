package com.example.mobileapp_final.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    var name by remember { mutableStateOf("John Doe") }
    var major by remember { mutableStateOf("Computer Science") }
    var year by remember { mutableStateOf("Junior") }
    var bio by remember { mutableStateOf("Passionate about software development and learning new technologies.") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Surface(
                modifier = Modifier
                    .size(120.dp),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.primaryContainer
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.first().toString(),
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Profile Information
            ProfileField(
                label = "Name",
                value = name,
                onValueChange = { name = it }
            )
            
            ProfileField(
                label = "Major",
                value = major,
                onValueChange = { major = it }
            )
            
            ProfileField(
                label = "Year",
                value = year,
                onValueChange = { year = it }
            )
            
            ProfileField(
                label = "Bio",
                value = bio,
                onValueChange = { bio = it },
                isMultiline = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Enrolled Courses Section
            Text(
                text = "Enrolled Courses",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.Start)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("CS101 - Introduction to Computer Science")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("CS201 - Data Structures and Algorithms")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("CS301 - Database Systems")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isMultiline: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            maxLines = if (isMultiline) 3 else 1,
            trailingIcon = {
                IconButton(onClick = { /* TODO: Implement edit functionality */ }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
            }
        )
    }
} 