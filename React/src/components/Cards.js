import React from 'react'
import Card from './Card'

const cards = [
  {
    id: 1,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 4,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 5,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 6,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 7,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  
  {
    id: 8,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 9,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 10,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 11,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 12,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 13,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 14,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  
  {
    id: 15,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 16,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 17,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 18,
    title: " Web",
    image: '',
    url: "https://web.com",
  },
  {
    id: 2,
    title: " Blog",
    image: '',
    url: "https://blog.web.com",
  },
  {
    id: 3,
    title: " Youtube",
    image: '',
    url: "https://youtube.com/tech",
  },
];

function Cards() {
    return (
      <div className="container d-flex justify-content-center align-items-center h-100 mt-5">
        <div className="row d-flex justify-content-center h-100">
          {cards.map(({ title, image, url, id }) => (
            <div className="col-md-4" key={id}>
              <Card imageSource={image} title={title} url={url} />
            </div>
          ))}
        </div>
      </div>
    );
  }

export default Cards