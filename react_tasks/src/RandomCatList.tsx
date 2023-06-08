import {Grid} from "@mui/material";


export default function RandomCatList({cards} : {cards : any[]}){
  return(
    <Grid container spacing={2}>
      <Grid item xs={12}>
        {cards.map(card => {
          return <img src={card} alt="a random cat"/>
        })}
      </Grid>
    </Grid>
  );
}