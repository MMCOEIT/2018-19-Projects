
# coding: utf-8

# # The UNSW-NB15 data set

# In[45]:


import pandas as pd


# In[46]:


unsw = pd.read_csv('UNSW_training-set.csv')


# In[47]:


unsw.tail()


# In[48]:


unsw.columns


# In[42]:


unsw[cols_to_norm] = unsw[cols_to_norm].apply(lambda x: (x - x.min()) / (x.max()-x.min() ))


# In[161]:


import tensorflow as tf


# In[175]:


dur = tf.feature_column.numeric_column('dur')
spkts = tf.feature_column.numeric_column('spkts')
dpkts = tf.feature_column.numeric_column('dpkts')
sbytes = tf.feature_column.numeric_column('sbytes')
dbytes = tf.feature_column.numeric_column('dbytes')
rate = tf.feature_column.numeric_column('rate')
sttl = tf.feature_column.numeric_column('sttl')
dttl = tf.feature_column.numeric_column('dttl')
sload = tf.feature_column.numeric_column('sload')
dload = tf.feature_column.numeric_column('dload')
sloss = tf.feature_column.numeric_column('sloss')
dloss = tf.feature_column.numeric_column('dloss')
sinpkt = tf.feature_column.numeric_column('sinpkt')
dinpkt = tf.feature_column.numeric_column('dinpkt')
synack = tf.feature_column.numeric_column('synack')
ackdat = tf.feature_column.numeric_column('ackat')
smean = tf.feature_column.numeric_column('smean')
dmean = tf.feature_column.numeric_column('dmean')



# In[176]:


assigned_grp = tf.feature_column.categorical_column_with_vocabulary_list('attack_cat', ['Fuzzers', 'Analysis', 'Backdoors', 'DoS', 'Exploits', 'Generic', 'Reconnaissance', 'Shellcode', 'Worms'])


# In[177]:


import matplotlib.pyplot as plt
get_ipython().magic('matplotlib inline')


# In[178]:


feat_cols = [dur,spkts,dpkts, sbytes, dbytes, rate, sttl, sload, dload, sloss, dloss, sinpkt,dinpkt, smean, dmean]


# In[179]:


x_data = unsw.drop('label', axis = 1)


# In[180]:


labels = unsw['label']


# In[181]:


from sklearn.model_selection import train_test_split


# In[182]:


X_train, x_test, y_train, y_test = train_test_split(x_data, labels, test_size = 0.3, random_state = 101)


# In[183]:


input_func = tf.estimator.inputs.pandas_input_fn(x = X_train, y = y_train, batch_size=10, num_epochs=1000, shuffle=True)


# In[184]:


model = tf.estimator.LinearClassifier(featurinput_func = tf.estimator.inputs.pandas_input_fn(x = X_train, y = y_train, batch_size=10, num_epochs=1000, shuffle=True)e_columns=feat_cols, n_classes=2)


# In[185]:


model.train(input_fn=input_func, steps=1000)


# In[72]:


unsw.columns


# In[75]:


x_data.columns


# In[145]:


x_data = x_data.drop('state', axis = 1)


# In[146]:


x_data.head()


# In[147]:


x_data.columns


# In[148]:


cols_to_norm = ['dur', 'spkts', 'dpkts', 'sbytes', 'dbytes', 'rate',
       'sttl', 'dttl', 'sload', 'dload', 'sloss', 'dloss', 'sinpkt', 'dinpkt',
       'sjit', 'djit', 'swin', 'stcpb', 'dtcpb', 'dwin', 'synack', 'ackdat',
       'smean', 'dmean']


# In[149]:


x_data[cols_to_norm] = x_data[cols_to_norm].apply(lambda x: (x - x.min())/(x.max()-x.min()))


# In[209]:


eval_input_function = tf.estimator.inputs.pandas_input_fn(x = x_test, y = y_test, batch_size=10, num_epochs=1,shuffle=False)


# In[188]:


results = model.evaluate(eval_input_function)


# In[210]:


results


# In[191]:


pred_input_func = tf.estimator.inputs.pandas_input_fn(x = x_test, batch_size=10, num_epochs=1, shuffle=False)


# In[193]:


predictions = model.predict(pred_input_func)


# In[194]:


my_pred = list(predictions)


# In[195]:


my_pred


# ## DNN classifier

# In[196]:


dnn_model = tf.estimator.DNNClassifier(hidden_units=[10,10,10], feature_columns = feat_cols, n_classes=2)


# In[197]:


embedded_group_col = tf.feature_column.embedding_column(assigned_grp, dimension=9)


# In[198]:


feat_cols = [dur,spkts,dpkts, sbytes, dbytes, rate, sttl, sload, dload, sloss, dloss, sinpkt,dinpkt, smean, dmean, embedded_group_col]


# In[203]:


input_func = tf.estimator.inputs.pandas_input_fn(X_train, y_train, batch_size=10, num_epochs=1000, shuffle=True)


# In[204]:


dnn_model = tf.estimator.DNNClassifier(hidden_units=[10,10,10], feature_columns=feat_cols, n_classes=2)


# In[205]:


dnn_model.train(input_fn=input_func, steps = 1000)


# In[207]:


eval_input_func = tf.estimator.inputs.pandas_input_fn(x = x_test, y = y_test, num_epochs=1, batch_size=10, shuffle=False)


# In[208]:


dnn_model.evaluate(eval_input_func)


# In[ ]:




