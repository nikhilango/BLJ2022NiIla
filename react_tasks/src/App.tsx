import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import { AppBar, Box, Container, Grid, Typography } from '@mui/material';
import CatImageService from './service/CatImageService';
import RandomCatList from './RandomCatList';



function App() {
  const [catImageUrl, setCatImageUrl] = useState<string[]>([]);
  const imageUrls: string[] = [];
  useEffect(() => {
    const fetchCatImages = async () => {
      for (let i = 0; i < 3; i++) {
        const imageUrl = await CatImageService().getRandomCatImage();
        imageUrls[i] = imageUrl;
      }
      setCatImageUrl(imageUrls);
    };
    fetchCatImages();
  }, []);
 

  return (
    <div className="App">
      <Box sx={{ flexGrow: 1 }}>
        <Container maxWidth="lg">
          <AppBar position="static">
          </AppBar>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <Typography variant="h4" component="h2">
                Form here
              </Typography>
            </Grid>
          </Grid>
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <RandomCatList cards={catImageUrl}></RandomCatList>
            </Grid>
          </Grid>
        </Container>
      </Box>
    </div>
  );
}

export default App;
